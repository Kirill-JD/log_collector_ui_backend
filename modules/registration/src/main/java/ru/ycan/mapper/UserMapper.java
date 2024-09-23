package ru.ycan.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.ycan.dto.SignupDTO;
import ru.ycan.dto.UserDTO;
import ru.ycan.entity.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password", qualifiedByName = "getPasswordEncode")
    User signupDtoToUser(SignupDTO signupDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    UserDTO userToUserDto(User user);

    @Named("getPasswordEncode")
    default String getPasswordEncode(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
