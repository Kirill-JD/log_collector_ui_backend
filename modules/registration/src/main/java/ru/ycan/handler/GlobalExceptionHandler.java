package ru.ycan.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.ycan.rest.response.ErrorResponse;

import java.util.Optional;
import java.util.regex.Pattern;

import static ru.ycan.enums.Errors.*;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Pattern PATTERN = Pattern.compile("=\\((.+)\\) already exists");

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException exception) {
        var field = exception.getBindingResult().getFieldError();
        var message = field == null ? ERROR_BY_VALIDATION_REGISTRATION_DATA.getMessage()
                                    : INCORRECT_REGISTRATION_DATA.getMessage().formatted(field.getField(),
                                                                                          field.getDefaultMessage());
        log.error(message, exception);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(message));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleException(DataIntegrityViolationException exception) {
        var valueDuplicate = getValueDuplicate(exception.getMessage());
        var message = valueDuplicate.map(s -> DUPLICATE_VALUE_REGISTRATION_DATA.getMessage().formatted(s))
                                    .orElseGet(INCORRECT_VALUE_REGISTRATION_DATA::getMessage);
        log.error(message, exception);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(message));
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ErrorResponse> handleException(HttpMediaTypeNotSupportedException exception) {
        log.error(UNSUPPORTED_CONTENT_TYPE.getMessage(), exception);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(UNSUPPORTED_CONTENT_TYPE.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleException(HttpMessageNotReadableException exception) {
        log.error(REGISTRATION_DATA_MISSING.getMessage(), exception);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(REGISTRATION_DATA_MISSING.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        log.error(INTERNAL_SERVER_ERROR.getMessage(), exception);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(INTERNAL_SERVER_ERROR.getMessage()));
    }

    private Optional<String> getValueDuplicate(String message) {
        final var matcher = PATTERN.matcher(message);
        return matcher.find() ? Optional.of(matcher.group(1))
                              : Optional.empty();
    }
}
