package com.mx.edu.tecdesoftware.FilmVerse.api.persistence;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.SeriesD;
import com.mx.edu.tecdesoftware.FilmVerse.api.domain.repository.SeriesRepository;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.crud.SerieCrudRepository;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.entity.Serie;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.mapper.SeriesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SerieRepository implements SeriesRepository {

    @Autowired
    private SerieCrudRepository serieCrudRepository;

    @Autowired
    private SeriesMapper mapper;

    @Override
    public List<SeriesD> getAll() {
        return mapper.toSeries((List<Serie>) serieCrudRepository.findAll());
    }

    @Override
    public Optional<SeriesD> getById(Integer seriesId) {
        return serieCrudRepository.findById(seriesId)
                .map(serie -> mapper.toSeriesD(serie));
    }

    @Override
    public SeriesD save(SeriesD series) {
        Serie serie = mapper.toSerie(series);
        return mapper.toSeriesD(serieCrudRepository.save(serie));
    }

    @Override
    public void delete(Integer seriesId) {
        serieCrudRepository.deleteById(seriesId);
    }

    @Override
    public Optional<SeriesD> getByTitle(String title) {

        return serieCrudRepository.findByTitulo(title)
                .map(serie -> mapper.toSeriesD(serie));

    }
}