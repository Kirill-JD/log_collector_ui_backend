package ru.ycan.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Errors {
    REGISTRATION_DATA_MISSING("Отсутствуют данные для регистрации"),
    UNSUPPORTED_CONTENT_TYPE("Неподдерживаемый 'Content-type'"),
    ERROR_BY_VALIDATION_REGISTRATION_DATA("Ошибка при валидации данных регистрации"),
    INCORRECT_REGISTRATION_DATA("Поле '%s' %s"),
    DUPLICATE_VALUE_REGISTRATION_DATA("Значение '%s' уже используется"),
    INCORRECT_VALUE_REGISTRATION_DATA("Данные уже используются"),
    INTERNAL_SERVER_ERROR("Внутренняя ошибка сервиса");

    private final String message;
}
