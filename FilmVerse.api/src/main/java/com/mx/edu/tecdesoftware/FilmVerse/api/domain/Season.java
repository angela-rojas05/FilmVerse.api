package com.mx.edu.tecdesoftware.FilmVerse.api.domain;

import java.time.LocalDate;
import java.util.List;

public class Season {

    private Integer seasonId;
    private Integer seasonNumber;
    private LocalDate releaseDate;
    private String description;

    private SeriesD series;

    private List<Episode> episodes;

    public Integer getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SeriesD getSeries() {
        return series;
    }

    public void setSeries(SeriesD series) {
        this.series = series;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

}