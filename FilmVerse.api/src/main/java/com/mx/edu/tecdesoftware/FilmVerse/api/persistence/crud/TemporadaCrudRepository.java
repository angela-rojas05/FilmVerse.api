package com.mx.edu.tecdesoftware.FilmVerse.api.persistence.crud;

import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.entity.Temporada;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TemporadaCrudRepository extends CrudRepository<Temporada, Integer> {
    Optional<Temporada> findBySerieSerieIdAndNumeroTemporada(
            Integer serieId,
            Integer numeroTemporada
    );
}
