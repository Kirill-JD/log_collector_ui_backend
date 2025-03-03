package ru.ycan.registration.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ycan.registration.dto.SignupDTO;
import ru.ycan.registration.dto.UserDTO;
import ru.ycan.registration.entity.User;
import ru.ycan.registration.mapper.UserMapper;
import ru.ycan.registration.repository.UserRepository;
import ru.ycan.registration.service.DatabaseService;

import static ru.ycan.registration.enums.Messages.USER_SUCCESSFULLY_REGISTERED;

@Slf4j
@Service
@RequiredArgsConstructor
public class DatabaseServiceImpl implements DatabaseService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserDTO createUser(SignupDTO signupDTO) {
        var user = userMapper.signupDtoToUser(signupDTO);
        User createdUser = userRepository.save(user);
        log.info(USER_SUCCESSFULLY_REGISTERED.getMessage(), createdUser.getUsername());
        return userMapper.userToUserDto(createdUser);
    }
}
