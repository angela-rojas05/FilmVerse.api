package com.mx.edu.tecdesoftware.FilmVerse.api.persistence.mapper;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.User;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "usuarioId", target = "userId")
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "correo", target = "email")
    @Mapping(source = "contrasena", target = "password")
    User toUser(Usuario usuario);

    @Mapping(source = "userId", target = "usuarioId")
    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "email", target = "correo")
    @Mapping(source = "password", target = "contrasena")
    Usuario toUsuario(User user);

    List<User> toUsers(List<Usuario> usuarios);

    List<Usuario> toUsuarios(List<User> users);

}