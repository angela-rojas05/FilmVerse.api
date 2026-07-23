package com.mx.edu.tecdesoftware.FilmVerse.api.persistence.mapper;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.Season;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.entity.Temporada;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SeasonMapper {

    @Mapping(source = "temporadaId", target = "seasonId")
    @Mapping(source = "numeroTemporada", target = "seasonNumber")
    @Mapping(source = "fechaLanzamiento", target = "releaseDate")
    Season toSeason(Temporada temporada);

    @Mapping(source = "seasonId", target = "temporadaId")
    @Mapping(source = "seasonNumber", target = "numeroTemporada")
    @Mapping(source = "releaseDate", target = "fechaLanzamiento")
    Temporada toTemporada(Season seasonD);

}
