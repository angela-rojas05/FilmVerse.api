package com.mx.edu.tecdesoftware.FilmVerse.api.domain.repository;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.Season;

import java.util.List;
import java.util.Optional;

public interface SeasonRepository {

    List<Season> getAll();

    Optional<Season> getById(Integer seasonId);

    Season save(Season season);

    void delete(Integer seasonId);

}
