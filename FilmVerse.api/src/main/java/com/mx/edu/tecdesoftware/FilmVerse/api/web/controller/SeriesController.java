package com.mx.edu.tecdesoftware.FilmVerse.api.web.controller;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.SeriesD;
import com.mx.edu.tecdesoftware.FilmVerse.api.domain.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SeriesController {

    @Autowired
    private SerieService serieService;

    @GetMapping
    public ResponseEntity<List<SeriesD>> getAll() {
        return new ResponseEntity<>(serieService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeriesD> getById(@PathVariable("id") Integer seriesId) {
        return serieService.getById(seriesId)
                .map(series -> new ResponseEntity<>(series, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<SeriesD> save(@RequestBody SeriesD series) {
        return new ResponseEntity<>(serieService.save(series), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer seriesId) {
        serieService.delete(seriesId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}