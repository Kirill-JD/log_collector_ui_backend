package ru.ycan.handler.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import ru.ycan.dto.AuthenticationDTO;
import ru.ycan.handler.AuthenticationHandler;
import ru.ycan.rest.response.AuthenticationResponse;
import ru.ycan.util.JwtUtil;

import static ru.ycan.enums.Messages.AUTHORIZATION_SUCCESSFUL;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthenticationHandlerImpl implements AuthenticationHandler {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @Override
    public AuthenticationResponse authentication(AuthenticationDTO authenticationDTO) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDTO.email(),
                                                                                   authenticationDTO.password()));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDTO.email());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        log.info(AUTHORIZATION_SUCCESSFUL.getMessage(), userDetails.getUsername());
        return new AuthenticationResponse(jwt);
    }
}
