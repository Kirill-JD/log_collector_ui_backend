package ru.ycan.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Errors {
    USER_NOT_FOUND("Пользователь не найден"),
    USER_NOT_ACTIVE("Пользователь не активен"),
    INCORRECT_AUTHORIZATION_DATA("Поле '%s' %s"),
    ERROR_BY_VALIDATION_AUTHORIZATION_DATA("Ошибка при валидации данных авторизации"),
    INVALID_AUTHORIZATION_DATA("Неверное имя пользователя или пароль!"),
    INTERNAL_SERVER_ERROR("Внутренняя ошибка сервиса");

    private final String message;
}
