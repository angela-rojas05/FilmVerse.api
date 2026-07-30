package com.mx.edu.tecdesoftware.FilmVerse.api.domain.repository;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.Studio;

import java.util.List;
import java.util.Optional;

public interface StudioRepository {

    List<Studio> getAll();

    Optional<Studio> getById(Integer studioId);

    Studio save(Studio studio);

    void delete(Integer studioId);

    Optional<Studio> getByName(String name);

}