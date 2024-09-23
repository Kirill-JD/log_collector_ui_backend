package ru.ycan.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Errors {
    REGISTRATION_DATA_MISSING(" Отсутствуют данные для регистрации"),
    INTERNAL_SERVER_ERROR("Внутренняя ошибка сервиса");

    private final String message;
}
