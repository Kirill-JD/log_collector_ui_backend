package ru.ycan.authentication.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Messages {
    AUTHORIZATION_SUCCESSFUL("Пользователь '{}' успешно авторизован");

    private final String message;
}
