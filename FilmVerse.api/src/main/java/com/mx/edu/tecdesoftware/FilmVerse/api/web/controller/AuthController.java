package com.mx.edu.tecdesoftware.FilmVerse.api.web.controller;

import com.mx.edu.tecdesoftware.FilmVerse.api.domain.service.AuthService;
import com.mx.edu.tecdesoftware.FilmVerse.api.web.controller.dto.LoginRequest;
import com.mx.edu.tecdesoftware.FilmVerse.api.web.controller.dto.LoginResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(
        name = "Authentication",
        description = "Endpoints for user authentication and JWT token management"
)
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(
            summary = "User login",
            description = "Authenticates a user using their email and password and generates a JWT token"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Login successful"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Invalid credentials"
            )
    })
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request
    ) {

        String token = authService.login(request);

        return ResponseEntity.ok(
                new LoginResponse(token)
        );
    }
}