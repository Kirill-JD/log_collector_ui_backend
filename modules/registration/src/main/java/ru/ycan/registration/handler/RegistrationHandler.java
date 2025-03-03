package ru.ycan.registration.handler;


import ru.ycan.registration.dto.SignupDTO;
import ru.ycan.registration.dto.UserDTO;

public interface RegistrationHandler {
    UserDTO registration(SignupDTO signupDTO);
}
