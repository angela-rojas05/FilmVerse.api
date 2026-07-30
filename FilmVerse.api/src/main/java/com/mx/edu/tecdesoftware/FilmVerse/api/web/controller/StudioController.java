package com.mx.edu.tecdesoftware.FilmVerse.api.web.controller;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.Studio;
import com.mx.edu.tecdesoftware.FilmVerse.api.domain.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studios")
public class StudioController {

    @Autowired
    private StudioService studioService;

    @GetMapping
    public ResponseEntity<Iterable<Studio>> getAll() {
        return new ResponseEntity<>(studioService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Studio> getById(@PathVariable("id") Integer studioId) {
        return studioService.getById(studioId)
                .map(studio -> new ResponseEntity<>(studio, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Studio> save(@RequestBody Studio studio) {
        return new ResponseEntity<>(studioService.save(studio), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer studioId) {
        studioService.delete(studioId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}