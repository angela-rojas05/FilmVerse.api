package com.mx.edu.tecdesoftware.FilmVerse.api.persistence.crud;

import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.entity.Serie;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SerieCrudRepository extends CrudRepository<Serie, Integer> {

    Optional<Serie> findByTitulo(String titulo);
}
