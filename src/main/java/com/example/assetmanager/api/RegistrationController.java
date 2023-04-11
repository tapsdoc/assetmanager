package com.example.assetmanager.api;

import com.example.assetmanager.service.user.UserService;
import com.example.assetmanager.service.user.registration.AuthRequest;
import com.example.assetmanager.service.user.registration.AuthResponse;
import com.example.assetmanager.service.user.registration.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true", exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
public class RegistrationController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse login(@RequestBody AuthRequest request) {
        return userService.login(request);
    }
}
