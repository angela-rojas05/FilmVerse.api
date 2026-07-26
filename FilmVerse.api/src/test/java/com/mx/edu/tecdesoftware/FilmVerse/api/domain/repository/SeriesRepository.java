package com.mx.edu.tecdesoftware.FilmVerse.api.domain.repository;
import com.mx.edu.tecdesoftware.FilmVerse.api.domain.SeriesD;

import java.util.List;
import java.util.Optional;

public interface SeriesRepository {

    List<SeriesD> getAll();

    Optional<SeriesD> getById(Integer seriesId);

    SeriesD save(SeriesD series);

    void delete(Integer seriesId);

}
