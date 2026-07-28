package com.mx.edu.tecdesoftware.FilmVerse.api.persistence.mapper;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.Season;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.entity.Temporada;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SeriesMapper.class})
public interface SeasonMapper {

    @Mapping(source = "temporadaId", target = "seasonId")
    @Mapping(source = "numeroTemporada", target = "seasonNumber")
    @Mapping(source = "fechaLanzamiento", target = "releaseDate")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "serie", target = "series")
    @Mapping(target = "episodes", ignore = true)
    Season toSeason(Temporada temporada);

    @Mapping(source = "seasonId", target = "temporadaId")
    @Mapping(source = "seasonNumber", target = "numeroTemporada")
    @Mapping(source = "releaseDate", target = "fechaLanzamiento")
    @Mapping(source = "description", target = "descripcion")
    @Mapping(source = "series", target = "serie")
    @Mapping(target = "episodios", ignore = true)
    Temporada toTemporada(Season season);

    List<Season> toSeason(List<Temporada> temporadas);

    List<Temporada> toTemporada(List<Season> seasons);
}