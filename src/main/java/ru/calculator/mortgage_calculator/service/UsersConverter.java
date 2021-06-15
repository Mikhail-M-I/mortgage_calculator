package ru.calculator.mortgage_calculator.service;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import ru.calculator.mortgage_calculator.dto.UserDto;
import ru.calculator.mortgage_calculator.entity.User;

@Component
@Log
public class UsersConverter {

    public User fromUserDtoToUser(UserDto usersDto) {

        return User.builder()
                .id(100)
                .email(usersDto.getEmail())
                .login(usersDto.getLogin())
                .name(usersDto.getName())
                .build();
    }

    public UserDto fromUserToUserDto(User user) {

        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .login(user.getLogin())
                .name(user.getName())
                .build();
    }
}
