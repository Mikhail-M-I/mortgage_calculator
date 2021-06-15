package ru.calculator.mortgage_calculator.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.calculator.mortgage_calculator.dto.UserDto;
import ru.calculator.mortgage_calculator.exception.ValidationException;
import ru.calculator.mortgage_calculator.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Log
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/save")
    public UserDto saveUsers(@RequestBody UserDto usersDto) throws ValidationException {
        log.info("Handling save users: " + usersDto);
        return usersService.saveUser(usersDto);
    }

    @GetMapping("/findAll")
    public List<UserDto> findAllUsers() {
        log.info("Handling find all users request");
        return usersService.findAll();
    }

    @GetMapping("/findByLogin")
    public UserDto findByLogin(@RequestParam String login) {
        log.info("Handling find by login request: " + login);
        return usersService.findByLogin(login);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id) {
        log.info("Handling delete user request: " + id);
        usersService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
