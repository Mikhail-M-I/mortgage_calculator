package ru.calculator.mortgage_calculator.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class UserDto {

    private Integer id;
    private String name;
    private String login;
    private String email;
}
