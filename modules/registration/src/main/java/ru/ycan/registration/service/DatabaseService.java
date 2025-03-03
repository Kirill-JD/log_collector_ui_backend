package ru.ycan.registration.service;

import ru.ycan.registration.dto.SignupDTO;
import ru.ycan.registration.dto.UserDTO;

public interface DatabaseService {
    UserDTO createUser(SignupDTO signupDTO);
}