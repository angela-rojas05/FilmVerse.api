package com.mx.edu.tecdesoftware.FilmVerse.api.domain.service;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.Episode;
import com.mx.edu.tecdesoftware.FilmVerse.api.domain.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EpisodeService {

    @Autowired
    private EpisodeRepository episodeRepository;

    public List<Episode> getAll() {
        return episodeRepository.getAll();
    }

    public Optional<Episode> getById(Integer episodeId) {
        return episodeRepository.getById(episodeId);
    }

    public Episode save(Episode episode) {
        return episodeRepository.save(episode);
    }

    public void delete(Integer episodeId) {
        episodeRepository.delete(episodeId);
    }
}