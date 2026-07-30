package com.mx.edu.tecdesoftware.FilmVerse.api.web.controller;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.Episode;
import com.mx.edu.tecdesoftware.FilmVerse.api.domain.service.EpisodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/episodes")
@Tag(name = "Episode", description = "Manage episodes in the streaming platform")
public class EpisodeController {

    @Autowired
    private EpisodeService episodeService;

    @GetMapping("")
    @Operation(
            summary = "Get all episodes",
            description = "Return a list of all registered episodes"
    )
    @ApiResponse(responseCode = "200", description = "Successful retrieval of episodes")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<List<Episode>> getAll() {
        return new ResponseEntity<>(episodeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get episode by ID",
            description = "Return an episode by its ID if it exists"
    )
    @ApiResponse(responseCode = "200", description = "Episode found")
    @ApiResponse(responseCode = "404", description = "Episode not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Episode> getById(
            @Parameter(
                    description = "ID of the episode to be retrieved",
                    example = "1",
                    required = true
            )
            @PathVariable("id") Integer episodeId) {

        return episodeService.getById(episodeId)
                .map(episode -> new ResponseEntity<>(episode, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    @Operation(
            summary = "Create a new episode",
            description = "Register a new episode and return it",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            examples = @ExampleObject(
                                    name = "Example Episode",
                                    value =
                                            """
                                            {
                                              "episodeNumber": 1,
                                              "title": "Pilot",
                                              "duration": 57,
                                              "description": "Rue returns home after rehab and struggles to adjust to everyday life.",
                                              "season": {
                                                "seasonId": 8
                                              }
                                            }
                                            """
                            )
                    )
            )
    )
    @ApiResponse(responseCode = "201", description = "Episode created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid episode data")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "409", description = "Episode already exists")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Episode> save(@RequestBody Episode episode) {
        return new ResponseEntity<>(episodeService.save(episode), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete an episode by ID",
            description = "Deletes an episode if it exists"
    )
    @ApiResponse(responseCode = "200", description = "Episode deleted successfully")
    @ApiResponse(responseCode = "400", description = "Invalid episode ID")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "404", description = "Episode not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Void> delete(
            @Parameter(
                    description = "ID of the episode to be deleted",
                    example = "1",
                    required = true
            )
            @PathVariable("id") Integer episodeId) {

        episodeService.delete(episodeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}