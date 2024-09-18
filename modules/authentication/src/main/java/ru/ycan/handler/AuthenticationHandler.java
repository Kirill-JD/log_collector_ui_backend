package ru.ycan.handler;

import ru.ycan.dto.AuthenticationDTO;
import ru.ycan.rest.response.AuthenticationResponse;

public interface AuthenticationHandler {
    AuthenticationResponse authentication(AuthenticationDTO authenticationDTO);
}
