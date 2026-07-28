package com.mx.edu.tecdesoftware.FilmVerse.api.persistence.mapper;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.SeriesD;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.entity.Serie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StudioMapper.class, GenreMapper.class})
public interface SeriesMapper {

    @Mapping(source = "serieId", target = "seriesId")
    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "sinopsis", target = "synopsis")
    @Mapping(source = "anioLanzamiento", target = "releaseYear")
    @Mapping(source = "estado", target = "status")
    @Mapping(source = "estudio", target = "studio")
    @Mapping(source = "genero", target = "genre")
    @Mapping(target = "seasons", ignore = true)
    SeriesD toSeriesD(Serie serie);

    @Mapping(source = "seriesId", target = "serieId")
    @Mapping(source = "title", target = "titulo")
    @Mapping(source = "synopsis", target = "sinopsis")
    @Mapping(source = "releaseYear", target = "anioLanzamiento")
    @Mapping(source = "status", target = "estado")
    @Mapping(source = "studio", target = "estudio")
    @Mapping(source = "genre", target = "genero")
    @Mapping(target = "temporadas", ignore = true)
    Serie toSerie(SeriesD seriesD);

    List<SeriesD> toSeries(List<Serie> series);

    List<Serie> toSerie(List<SeriesD> series);

}