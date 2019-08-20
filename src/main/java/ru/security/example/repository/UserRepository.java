package ru.security.example.repository;

import org.springframework.data.repository.CrudRepository;
import ru.security.example.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUserName(String username);
}
