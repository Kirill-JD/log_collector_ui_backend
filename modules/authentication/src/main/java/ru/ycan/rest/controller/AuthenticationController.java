package ru.ycan.rest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.ycan.dto.AuthenticationDTO;
import ru.ycan.handler.AuthenticationHandler;
import ru.ycan.rest.response.AuthenticationResponse;

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