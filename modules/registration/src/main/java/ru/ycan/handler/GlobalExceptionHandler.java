package ru.ycan.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.ycan.rest.response.ErrorResponse;

import static ru.ycan.enums.Errors.INTERNAL_SERVER_ERROR;
import static ru.ycan.enums.Errors.REGISTRATION_DATA_MISSING;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException exception) {
//        var field = exception.getBindingResult().getFieldError();
//        var message = field == null ? ERROR_BY_VALIDATION_AUTHORIZATION_DATA.getMessage()
//                                    : INCORRECT_AUTHORIZATION_DATA.getMessage().formatted(field.getField(),
//                                                                                          field.getDefaultMessage());
//        log.error(message, exception);
//        return ResponseEntity
//                .status(HttpStatus.FORBIDDEN)
//                .body(new ErrorResponse(message));
//    }





//
//    @ExceptionHandler(BadCredentialsException.class)
//    public ResponseEntity<ErrorResponse> handleException(BadCredentialsException exception) {
//        log.error(INVALID_AUTHORIZATION_DATA.getMessage(), exception);
//        return ResponseEntity
//                .status(HttpStatus.FORBIDDEN)
//                .body(new ErrorResponse(INVALID_AUTHORIZATION_DATA.getMessage()));
//    }
//
//    @ExceptionHandler(DisabledException.class)
//    public ResponseEntity<ErrorResponse> handleException(DisabledException exception) {
//        log.error(USER_NOT_ACTIVE.getMessage(), exception);
//        return ResponseEntity
//                .status(HttpStatus.FORBIDDEN)
//                .body(new ErrorResponse(USER_NOT_ACTIVE.getMessage()));
//    }

    // HttpMediaTypeNotSupportedException (text body)
    // DataIntegrityViolationException (дубль)


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
}
