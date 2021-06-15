package ru.calculator.mortgage_calculator.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.calculator.mortgage_calculator.dto.UserDto;
import ru.calculator.mortgage_calculator.entity.User;
import ru.calculator.mortgage_calculator.exception.ValidationException;
import ru.calculator.mortgage_calculator.repository.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
@Log
public class DefaultUsersService implements UsersService {

    private final UsersRepository usersRepository;
    private final UsersConverter usersConverter;

    private void validateUserDto(UserDto userDto) throws ValidationException {
        if (isNull(userDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(userDto.getLogin()) || userDto.getLogin().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
    }

    @Override
    public UserDto saveUser(UserDto userDto) throws ValidationException {
        validateUserDto(userDto);
        User savedUser = usersRepository.save(usersConverter.fromUserDtoToUser(userDto));
        return usersConverter.fromUserToUserDto(savedUser);
    }

    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public UserDto findByLogin(String login) {
        User user = usersRepository.findByLogin(login);
        if (user != null) {
            return usersConverter.fromUserToUserDto(user);
        }
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        return usersRepository.findAll()
                .stream()
                .map(usersConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }
}
