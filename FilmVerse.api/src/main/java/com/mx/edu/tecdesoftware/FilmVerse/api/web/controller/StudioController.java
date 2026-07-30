package com.mx.edu.tecdesoftware.FilmVerse.api.web.controller;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.Studio;
import com.mx.edu.tecdesoftware.FilmVerse.api.domain.service.StudioService;
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
@RequestMapping("/studios")
@Tag(name = "Studio", description = "Manage studios in the streaming platform")
public class StudioController {

    @Autowired
    private StudioService studioService;

    @GetMapping("")
    @Operation(
            summary = "Get all studios",
            description = "Return a list of all registered studios"
    )
    @ApiResponse(responseCode = "200", description = "Successful retrieval of studios")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<List<Studio>> getAll() {
        return new ResponseEntity<>(studioService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get studio by ID",
            description = "Return a studio by its ID if it exists"
    )
    @ApiResponse(responseCode = "200", description = "Studio found")
    @ApiResponse(responseCode = "404", description = "Studio not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Studio> getById(
            @Parameter(
                    description = "ID of the studio to be retrieved",
                    example = "1",
                    required = true
            )
            @PathVariable("id") Integer studioId) {

        return studioService.getById(studioId)
                .map(studio -> new ResponseEntity<>(studio, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    @Operation(
            summary = "Create a new studio",
            description = "Register a new studio and return it",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            examples = @ExampleObject(
                                    name = "Example Studio",
                                    value =
                                            """
                                            {
                                              "name": "A24",
                                              "country": "United States",
                                              "foundationYear": 2012
                                            }
                                            """
                            )
                    )
            )
    )
    @ApiResponse(responseCode = "201", description = "Studio created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid studio data")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "409", description = "Studio already exists")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Studio> save(@RequestBody Studio studio) {
        return new ResponseEntity<>(studioService.save(studio), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a studio by ID",
            description = "Deletes a studio if it exists"
    )
    @ApiResponse(responseCode = "200", description = "Studio deleted successfully")
    @ApiResponse(responseCode = "400", description = "Invalid studio ID")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "404", description = "Studio not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Void> delete(
            @Parameter(
                    description = "ID of the studio to be deleted",
                    example = "1",
                    required = true
            )
            @PathVariable("id") Integer studioId) {

        studioService.delete(studioId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}