package com.mx.edu.tecdesoftware.FilmVerse.api.persistence;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.Studio;
import com.mx.edu.tecdesoftware.FilmVerse.api.domain.repository.StudioRepository;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.crud.StudioCrudRepository;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.entity.Estudio;
import com.mx.edu.tecdesoftware.FilmVerse.api.persistence.mapper.StudioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EstudioRepository implements StudioRepository {

    @Autowired
    private StudioCrudRepository studioCrudRepository;

    @Autowired
    private StudioMapper mapper;

    @Override
    public List<Studio> getAll() {
        return mapper.toStudio((List<Estudio>) studioCrudRepository.findAll());
    }

    @Override
    public Optional<Studio> getById(Integer studioId) {
        return studioCrudRepository.findById(studioId)
                .map(estudio -> mapper.toStudio(estudio));
    }

    @Override
    public Studio save(Studio studio) {
        Estudio estudio = mapper.toEstudio(studio);
        return mapper.toStudio(studioCrudRepository.save(estudio));
    }

    @Override
    public void delete(Integer studioId) {
        studioCrudRepository.deleteById(studioId);
    }

    @Override
    public Optional<Studio> getByName(String name) {

        return studioCrudRepository.findByNombre(name)
                .map(estudio -> mapper.toStudio(estudio));

    }
}