package ru.calculator.mortgage_calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.calculator.mortgage_calculator.entity.User;

public interface UsersRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);
}
