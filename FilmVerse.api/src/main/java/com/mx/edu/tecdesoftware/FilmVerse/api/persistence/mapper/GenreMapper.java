package com.mx.edu.tecdesoftware.FilmVerse.api.persistence.mapper;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.Genre;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.entity.Genero;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    @Mapping(source = "generoId", target = "genreId")
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "descripcion", target = "description")
    Genre toGenre(Genero genero);

    @Mapping(source = "genreId", target = "generoId")
    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "description", target = "descripcion")
    Genero toGenero(Genre genre);

}