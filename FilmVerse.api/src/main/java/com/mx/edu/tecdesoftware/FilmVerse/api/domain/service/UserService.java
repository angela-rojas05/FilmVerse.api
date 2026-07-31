package com.mx.edu.tecdesoftware.FilmVerse.api.domain.service;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.User;
import com.mx.edu.tecdesoftware.FilmVerse.api.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getById(Integer userId) {
        return userRepository.getById(userId);
    }

    public Optional<User> getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean delete(Integer userId) {
        return getById(userId).map(user -> {
            userRepository.delete(userId);
            return true;
        }).orElse(false);
    }
}