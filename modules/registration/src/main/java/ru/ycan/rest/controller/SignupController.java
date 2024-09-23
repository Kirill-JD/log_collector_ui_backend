package ru.ycan.rest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.ycan.dto.SignupDTO;
import ru.ycan.dto.UserDTO;
import ru.ycan.handler.RegistrationHandler;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
public class SignupController {
    private final RegistrationHandler handler;
    @PostMapping("/sign-up")
    public UserDTO signupUser(@RequestBody @Valid SignupDTO signupDTO) {
        return handler.registration(signupDTO);
    }
}