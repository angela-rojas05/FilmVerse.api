package com.mx.edu.tecdesoftware.FilmVerse.api.persistence.crud;

import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.entity.Estudio;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudioCrudRepository extends CrudRepository<Estudio, Integer> {
    Optional<Estudio> findByNombre(String nombre);
}