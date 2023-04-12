package com.example.assetmanager.service.user;

import com.example.assetmanager.service.user.registration.AuthRequest;
import com.example.assetmanager.service.user.registration.AuthResponse;
import com.example.assetmanager.service.user.registration.RegisterRequest;

import java.util.List;

public interface UserService {

    AuthResponse register(RegisterRequest request);
    AuthResponse login(AuthRequest request);
    List<UserResponse> getAll();
    UserResponse getUser(Long id);
}
