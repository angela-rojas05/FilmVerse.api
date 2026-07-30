package com.mx.edu.tecdesoftware.FilmVerse.api.web.controller;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.SeriesD;
import com.mx.edu.tecdesoftware.FilmVerse.api.domain.service.SerieService;
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
@RequestMapping("/series")
@Tag(name = "Series", description = "Manage series in the streaming platform")
public class SeriesController {

    @Autowired
    private SerieService serieService;

    @GetMapping("")
    @Operation(
            summary = "Get all series",
            description = "Return a list of all registered series"
    )
    @ApiResponse(responseCode = "200", description = "Successful retrieval of series")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<List<SeriesD>> getAll() {
        return new ResponseEntity<>(serieService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get series by ID",
            description = "Return a series by its ID if it exists"
    )
    @ApiResponse(responseCode = "200", description = "Series found")
    @ApiResponse(responseCode = "404", description = "Series not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<SeriesD> getById(
            @Parameter(
                    description = "ID of the series to be retrieved",
                    example = "1",
                    required = true
            )
            @PathVariable("id") Integer seriesId) {

        return serieService.getById(seriesId)
                .map(series -> new ResponseEntity<>(series, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    @Operation(
            summary = "Create a new series",
            description = "Register a new series and return it",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            examples = @ExampleObject(
                                    name = "Example Series",
                                    value =
                                            """
                                            {
                                              "title": "Euphoria",
                                              "synopsis": "A group of high school students navigate love, identity, friendships and addiction while facing the challenges of growing up.",
                                              "releaseYear": 2019,
                                              "status": "Active",
                                              "studio": {
                                                "studioId": 2
                                              },
                                              "genre": {
                                                "genreId": 2
                                              }
                                            }
                                            """
                            )
                    )
            )
    )
    @ApiResponse(responseCode = "201", description = "Series created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid series data")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "409", description = "Series already exists")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<SeriesD> save(@RequestBody SeriesD series) {
        return new ResponseEntity<>(serieService.save(series), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a series by ID",
            description = "Deletes a series if it exists"
    )
    @ApiResponse(responseCode = "200", description = "Series deleted successfully")
    @ApiResponse(responseCode = "400", description = "Invalid series ID")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "404", description = "Series not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Void> delete(
            @Parameter(
                    description = "ID of the series to be deleted",
                    example = "1",
                    required = true
            )
            @PathVariable("id") Integer seriesId) {

        serieService.delete(seriesId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}