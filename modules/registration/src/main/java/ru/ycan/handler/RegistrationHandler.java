package ru.ycan.handler;


import ru.ycan.dto.SignupDTO;
import ru.ycan.dto.UserDTO;

public interface RegistrationHandler {
    UserDTO registration(SignupDTO signupDTO);
}
