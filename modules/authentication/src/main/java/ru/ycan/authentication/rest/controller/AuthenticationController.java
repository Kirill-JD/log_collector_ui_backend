package ru.ycan.authentication.rest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.ycan.authentication.dto.AuthenticationDTO;
import ru.ycan.authentication.handler.AuthenticationHandler;
import ru.ycan.authentication.rest.response.AuthenticationResponse;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationHandler handler;

    @PostMapping("/authenticate")
    public AuthenticationResponse createAuthenticationToken(@RequestBody @Valid AuthenticationDTO authenticationDTO) {
        return handler.authentication(authenticationDTO);
    }
}