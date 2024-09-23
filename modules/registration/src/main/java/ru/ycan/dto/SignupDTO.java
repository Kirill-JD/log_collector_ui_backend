package ru.ycan.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SignupDTO(@NotBlank String username,
                        @Email String email,
                        @NotBlank String password) {
}
