package ru.ycan.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Messages {
    USER_SUCCESSFULLY_REGISTERED("Пользователь '{}' успешно зарегистрирован");

    private final String message;
}
