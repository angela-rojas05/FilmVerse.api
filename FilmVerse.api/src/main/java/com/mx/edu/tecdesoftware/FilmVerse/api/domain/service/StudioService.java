package com.mx.edu.tecdesoftware.FilmVerse.api.domain.service;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.Studio;
import com.mx.edu.tecdesoftware.FilmVerse.api.domain.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudioService {

    @Autowired
    private StudioRepository studioRepository;

    public List<Studio> getAll() {
        return studioRepository.getAll();
    }

    public Optional<Studio> getById(Integer studioId) {
        return studioRepository.getById(studioId);
    }

    public Studio save(Studio studio) {

        if (studioRepository.getByName(studio.getName()).isPresent()) {
            throw new RuntimeException("Studio already exists");
        }

        return studioRepository.save(studio);

    }

    public void delete(Integer studioId) {
        studioRepository.delete(studioId);
    }

}