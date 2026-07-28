package com.mx.edu.tecdesoftware.FilmVerse.api.web.controller;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.Season;
import com.mx.edu.tecdesoftware.FilmVerse.api.domain.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seasons")
public class SeasonController {

    @Autowired
    private SeasonService seasonService;

    @GetMapping
    public ResponseEntity<List<Season>> getAll() {
        return new ResponseEntity<>(seasonService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Season> getById(@PathVariable("id") Integer seasonId) {
        return seasonService.getById(seasonId)
                .map(season -> new ResponseEntity<>(season, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Season> save(@RequestBody Season season) {
        return new ResponseEntity<>(seasonService.save(season), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer seasonId) {
        seasonService.delete(seasonId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}