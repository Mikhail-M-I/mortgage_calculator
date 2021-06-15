package ru.calculator.mortgage_calculator.service;

import ru.calculator.mortgage_calculator.dto.UserDto;
import ru.calculator.mortgage_calculator.exception.ValidationException;

import java.util.List;

public interface UsersService {

    UserDto saveUser(UserDto usersDto) throws ValidationException;

    void deleteUser(Integer userId);

    UserDto findByLogin(String login);

    List<UserDto> findAll();
}
