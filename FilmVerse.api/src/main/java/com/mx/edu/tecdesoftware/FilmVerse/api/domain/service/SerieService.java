package com.mx.edu.tecdesoftware.FilmVerse.api.domain.service;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.SeriesD;
import com.mx.edu.tecdesoftware.FilmVerse.api.domain.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService {

    @Autowired
    private SeriesRepository seriesRepository;

    public List<SeriesD> getAll() {
        return seriesRepository.getAll();
    }

    public Optional<SeriesD> getById(Integer seriesId) {
        return seriesRepository.getById(seriesId);
    }

    public SeriesD save(SeriesD series) {
        return seriesRepository.save(series);
    }

    public void delete(Integer seriesId) {
        seriesRepository.delete(seriesId);
    }
}