package com.mx.edu.tecdesoftware.FilmVerse.api.persistence.mapper;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.Episode;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.entity.Episodio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EpisodeMapper {

    @Mapping(source = "episodioId", target = "episodeId")
    @Mapping(source = "numeroEpisodio", target = "episodeNumber")
    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "duracion", target = "duration")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "temporada.temporadaId", target = "seasonId")
    Episode toEpisode(Episodio episodio);


    @Mapping(source = "episodeId", target = "episodioId")
    @Mapping(source = "episodeNumber", target = "numeroEpisodio")
    @Mapping(source = "title", target = "titulo")
    @Mapping(source = "duration", target = "duracion")
    @Mapping(source = "description", target = "descripcion")
    Episodio toEpisodio(Episode episode);

}
