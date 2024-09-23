package ru.ycan.handler.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.ycan.dto.SignupDTO;
import ru.ycan.dto.UserDTO;
import ru.ycan.handler.RegistrationHandler;
import ru.ycan.service.DatabaseService;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationHandlerImpl implements RegistrationHandler {

    private final DatabaseService databaseService;

    @Override
    public UserDTO registration(SignupDTO signupDTO) {
        return databaseService.createUser(signupDTO);
    }
}
