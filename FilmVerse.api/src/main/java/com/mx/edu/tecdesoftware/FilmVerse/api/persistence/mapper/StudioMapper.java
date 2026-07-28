package com.mx.edu.tecdesoftware.FilmVerse.api.persistence.mapper;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.Studio;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.entity.Estudio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudioMapper {

    @Mapping(source = "estudioId", target = "studioId")
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "pais", target = "country")
    @Mapping(source = "anioFundacion", target = "foundationYear")
    Studio toStudio(Estudio estudio);

    @Mapping(source = "studioId", target = "estudioId")
    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "country", target = "pais")
    @Mapping(source = "foundationYear", target = "anioFundacion")
    Estudio toEstudio(Studio studio);

}