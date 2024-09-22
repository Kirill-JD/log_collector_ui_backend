package ru.ycan.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(@Email String email,
                                @NotBlank String password) {
}
