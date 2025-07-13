package code.springframework.io.gson_api_demo.controller;

import com.google.gson.Gson;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import code.springframework.io.gson_api_demo.model.ExternalUser;
import code.springframework.io.gson_api_demo.service.ExternalApiService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final ExternalApiService apiService;
    private final Gson gson;

    public UserController(ExternalApiService apiService, Gson gson) {
        this.apiService = apiService;
        this.gson = gson;
    }

    @Operation(summary = "Get user by ID from external API")
    @GetMapping("/{id}")
    public ExternalUser getUser(@PathVariable int id) {
        return apiService.getUserFromExternalApi(id);
    }


    @Operation(summary = "Accepts a JSON and returns the parsed User")
    @PostMapping
    public ExternalUser createUser(@RequestBody String rawJson) {
        return gson.fromJson(rawJson, ExternalUser.class);
    }
}
