package com.mx.edu.tecdesoftware.FilmVerse.api.persistence.crud;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.entity.Episodio;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EpisodioCrudRepository extends CrudRepository<Episodio, Integer> {
    Optional<Episodio> findByTemporadaTemporadaIdAndNumeroEpisodio(
            Integer temporadaId,
            Integer numeroEpisodio
    );
}
