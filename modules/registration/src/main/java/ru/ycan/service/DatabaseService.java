package ru.ycan.service;

import ru.ycan.dto.SignupDTO;
import ru.ycan.dto.UserDTO;

public interface DatabaseService {
    UserDTO createUser(SignupDTO signupDTO);
}