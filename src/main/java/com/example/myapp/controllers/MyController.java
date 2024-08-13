package com.example.myapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "Example controller.", description = "Operations to practice.")
public class MyController {

    @Operation(summary = "Get a greeting message", description = "Returns a simple greeting message.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved greeting.", content = @Content(mediaType = "text/plain"))
    @GetMapping("/getGreeting")
    public String getGreeting() {
        return "Hello, World!";
    }

    @Operation(
            summary = "Submit data to the server",
            description = "Receives a string of data and returns a confirmation message with the received data.")
    @ApiResponse(responseCode = "200", description = "Data submitted successfully.", content = @Content(mediaType = "text/plain"))
    @PostMapping("/submit")
    public String submitData(
            @Parameter(
                    description = "The string data submitted by the client.",
                    example = "anything",
                    required = true
            )
            @RequestBody String data) {
        return "Data received: " + data;
    }

    @Operation(summary = "Retrieve user by ID.",
                description = "Fetches user information based on the provided user ID.")
    @ApiResponse(responseCode = "200", description = "User ID successfully retrieved.", content = @Content(mediaType = "text/plain"))
    @GetMapping("/user/{id}")
    public String getUserById(
            @Parameter(description = "The unique identifier of the user to retrieve.", example = "123", required = true)
            @PathVariable("id") Long id) {
        return "User ID: " + id;
    }

    @Operation(summary = "Search for items.",
            description = "Searches for items based on the provided query string.")
    @ApiResponse(responseCode = "200", description = "Search results successfully retrieved.",
                  content = @Content(mediaType = "text/plain"))
    @GetMapping("/search")
    public String search(
            @Parameter(description = "The search query string to filter results.", example = "smartphone")
            @RequestParam(name = "query", defaultValue = "") String query) {
        return "Search results for: " + query;
    }

}
