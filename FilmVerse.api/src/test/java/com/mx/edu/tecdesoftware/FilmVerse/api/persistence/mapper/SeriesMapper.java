package com.mx.edu.tecdesoftware.FilmVerse.api.persistence.mapper;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.SeriesD;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.entity.Serie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SeriesMapper {

    @Mapping(source = "serieId", target = "seriesId")
    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "sinopsis", target = "synopsis")
    @Mapping(source = "anioLanzamiento", target = "releaseYear")
    @Mapping(source = "estado", target = "status")
    SeriesD toSeriesD(Serie serie);

    @Mapping(source = "seriesId", target = "serieId")
    @Mapping(source = "title", target = "titulo")
    @Mapping(source = "synopsis", target = "sinopsis")
    @Mapping(source = "releaseYear", target = "anioLanzamiento")
    @Mapping(source = "status", target = "estado")
    Serie toSerie(SeriesD seriesD);

}