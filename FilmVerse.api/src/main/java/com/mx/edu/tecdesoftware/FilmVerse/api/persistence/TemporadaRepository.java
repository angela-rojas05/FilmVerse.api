package com.mx.edu.tecdesoftware.FilmVerse.api.persistence;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.Season;
import com.mx.edu.tecdesoftware.FilmVerse.api.domain.repository.SeasonRepository;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.crud.TemporadaCrudRepository;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.entity.Temporada;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.mapper.SeasonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TemporadaRepository implements SeasonRepository {

    @Autowired
    private TemporadaCrudRepository temporadaCrudRepository;

    @Autowired
    private SeasonMapper mapper;

    @Override
    public List<Season> getAll() {
        return mapper.toSeason((List<Temporada>) temporadaCrudRepository.findAll());
    }

    @Override
    public Optional<Season> getById(Integer seasonId) {
        return temporadaCrudRepository.findById(seasonId)
                .map(temporada -> mapper.toSeason(temporada));
    }

    @Override
    public Season save(Season season) {
        Temporada temporada = mapper.toTemporada(season);
        return mapper.toSeason(temporadaCrudRepository.save(temporada));
    }

    @Override
    public void delete(Integer seasonId) {
        temporadaCrudRepository.deleteById(seasonId);
    }
}