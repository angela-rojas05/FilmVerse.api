package com.mx.edu.tecdesoftware.FilmVerse.api.web.controller;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.Season;
import com.mx.edu.tecdesoftware.FilmVerse.api.domain.service.SeasonService;
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
@RequestMapping("/seasons")
@Tag(name = "Season", description = "Manage seasons in the streaming platform")
public class SeasonController {

    @Autowired
    private SeasonService seasonService;

    @GetMapping("")
    @Operation(
            summary = "Get all seasons",
            description = "Return a list of all registered seasons"
    )
    @ApiResponse(responseCode = "200", description = "Successful retrieval of seasons")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<List<Season>> getAll() {
        return new ResponseEntity<>(seasonService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get season by ID",
            description = "Return a season by its ID if it exists"
    )
    @ApiResponse(responseCode = "200", description = "Season found")
    @ApiResponse(responseCode = "404", description = "Season not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Season> getById(
            @Parameter(
                    description = "ID of the season to be retrieved",
                    example = "1",
                    required = true
            )
            @PathVariable("id") Integer seasonId) {

        return seasonService.getById(seasonId)
                .map(season -> new ResponseEntity<>(season, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    @Operation(
            summary = "Create a new season",
            description = "Register a new season and return it",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            examples = @ExampleObject(
                                    name = "Example Season",
                                    value =
                                            """
                                                    {
                                                      "seasonNumber": 1,
                                                      "releaseDate": "2019-06-16",
                                                      "description": "First season of Euphoria.",
                                                      "series": {
                                                        "seriesId": 12
                                                      }
                                                    }
                                            """
                            )
                    )
            )
    )
    @ApiResponse(responseCode = "201", description = "Season created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid season data")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "409", description = "Season already exists")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Season> save(@RequestBody Season season) {
        return new ResponseEntity<>(seasonService.save(season), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a season by ID",
            description = "Deletes a season if it exists"
    )
    @ApiResponse(responseCode = "200", description = "Season deleted successfully")
    @ApiResponse(responseCode = "400", description = "Invalid season ID")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "404", description = "Season not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Void> delete(
            @Parameter(
                    description = "ID of the season to be deleted",
                    example = "1",
                    required = true
            )
            @PathVariable("id") Integer seasonId) {

        seasonService.delete(seasonId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}