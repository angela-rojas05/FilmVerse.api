package com.mx.edu.tecdesoftware.FilmVerse.api.persistence;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.User;
import com.mx.edu.tecdesoftware.FilmVerse.api.domain.repository.UserRepository;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.crud.UsuarioCrudRepository;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.entity.Usuario;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> getAll() {
        return mapper.toUsers((List<Usuario>) usuarioCrudRepository.findAll());
    }

    @Override
    public Optional<User> getById(Integer userId) {
        return usuarioCrudRepository.findById(userId)
                .map(mapper::toUser);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return usuarioCrudRepository.findByCorreo(email)
                .map(mapper::toUser);
    }

    @Override
    public User save(User user) {
        Usuario usuario = mapper.toUsuario(user);
        return mapper.toUser(usuarioCrudRepository.save(usuario));
    }

    @Override
    public void delete(Integer userId) {
        usuarioCrudRepository.deleteById(userId);
    }
}
