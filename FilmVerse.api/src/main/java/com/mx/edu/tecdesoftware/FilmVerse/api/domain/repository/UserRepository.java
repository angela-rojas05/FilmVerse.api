package com.mx.edu.tecdesoftware.FilmVerse.api.domain.repository;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> getAll();

    Optional<User> getById(Integer userId);

    Optional<User> getByEmail(String email);

    User save(User user);

    void delete(Integer userId);

}
