package com.mx.edu.tecdesoftware.FilmVerse.api.domain.repository;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.Episode;

import java.util.List;
import java.util.Optional;

public interface EpisodeRepository {

    List<Episode> getAll();

    Optional<Episode> getById(Integer episodeId);

    Episode save(Episode episode);

    void delete(Integer episodeId);

}
