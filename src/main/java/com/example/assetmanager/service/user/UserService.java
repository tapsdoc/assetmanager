package com.example.assetmanager.service.user;

import com.example.assetmanager.common.Users;
import com.example.assetmanager.service.user.registration.AuthRequest;
import com.example.assetmanager.service.user.registration.AuthResponse;
import com.example.assetmanager.service.user.registration.RegisterRequest;

public interface UserService {

    String signUp(Users users);
    AuthResponse register(RegisterRequest request);
    AuthResponse login(AuthRequest request);
}
