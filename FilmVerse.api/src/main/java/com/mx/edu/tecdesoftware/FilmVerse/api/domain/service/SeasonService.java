package com.mx.edu.tecdesoftware.FilmVerse.api.domain.service;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.Season;
import com.mx.edu.tecdesoftware.FilmVerse.api.domain.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonService {

    @Autowired
    private SeasonRepository seasonRepository;

    public List<Season> getAll() {
        return seasonRepository.getAll();
    }

    public Optional<Season> getById(Integer seasonId) {
        return seasonRepository.getById(seasonId);
    }

    public Season save(Season season) {

        if (seasonRepository.getBySeriesAndNumber(
                season.getSeries().getSeriesId(),
                season.getSeasonNumber()).isPresent()) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Season already exists"
            );
        }

        return seasonRepository.save(season);

    }

    public void delete(Integer seasonId) {
        seasonRepository.delete(seasonId);
    }
}