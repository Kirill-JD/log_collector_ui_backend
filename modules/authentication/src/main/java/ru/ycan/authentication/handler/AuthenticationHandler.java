package ru.ycan.authentication.handler;

import ru.ycan.authentication.dto.AuthenticationDTO;
import ru.ycan.authentication.rest.response.AuthenticationResponse;

public interface AuthenticationHandler {
    AuthenticationResponse authentication(AuthenticationDTO authenticationDTO);
}
