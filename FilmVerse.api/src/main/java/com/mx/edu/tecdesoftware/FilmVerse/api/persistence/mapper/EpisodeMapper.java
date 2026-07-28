package com.mx.edu.tecdesoftware.FilmVerse.api.persistence.mapper;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.Episode;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.entity.Episodio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SeasonMapper.class})
public interface EpisodeMapper {

    @Mapping(source = "episodioId", target = "episodeId")
    @Mapping(source = "numeroEpisodio", target = "episodeNumber")
    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "duracion", target = "duration")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "temporada", target = "season")
    Episode toEpisode(Episodio episodio);

    @Mapping(source = "episodeId", target = "episodioId")
    @Mapping(source = "episodeNumber", target = "numeroEpisodio")
    @Mapping(source = "title", target = "titulo")
    @Mapping(source = "duration", target = "duracion")
    @Mapping(source = "description", target = "descripcion")
    @Mapping(source = "season", target = "temporada")
    Episodio toEpisodio(Episode episode);

    List<Episode> toEpisode(List<Episodio> episodios);

    List<Episodio> toEpisodio(List<Episode> episodes);

}