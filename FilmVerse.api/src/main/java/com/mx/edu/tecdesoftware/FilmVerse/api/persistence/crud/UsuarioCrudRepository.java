package com.mx.edu.tecdesoftware.FilmVerse.api.persistence.crud;

import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer> {

    Optional<Usuario> findByCorreo(String correo);

}