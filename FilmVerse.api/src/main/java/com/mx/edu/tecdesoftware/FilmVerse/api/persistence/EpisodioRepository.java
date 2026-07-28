package com.mx.edu.tecdesoftware.FilmVerse.api.persistence;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.Episode;
import com.mx.edu.tecdesoftware.FilmVerse.api.domain.repository.EpisodeRepository;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.crud.EpisodioCrudRepository;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.entity.Episodio;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.mapper.EpisodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EpisodioRepository implements EpisodeRepository {

    @Autowired
    private EpisodioCrudRepository episodioCrudRepository;

    @Autowired
    private EpisodeMapper mapper;

    @Override
    public List<Episode> getAll() {
        return mapper.toEpisode((List<Episodio>) episodioCrudRepository.findAll());
    }

    @Override
    public Optional<Episode> getById(Integer episodeId) {
        return episodioCrudRepository.findById(episodeId)
                .map(episodio -> mapper.toEpisode(episodio));
    }

    @Override
    public Episode save(Episode episode) {
        Episodio episodio = mapper.toEpisodio(episode);
        return mapper.toEpisode(episodioCrudRepository.save(episodio));
    }

    @Override
    public void delete(Integer episodeId) {
        episodioCrudRepository.deleteById(episodeId);
    }
}