package com.example.assetmanager.service.user;

import com.example.assetmanager.common.Role;
import com.example.assetmanager.domain.Users;
import com.example.assetmanager.repository.UserRepo;
import com.example.assetmanager.security.JwtService;
import com.example.assetmanager.service.user.registration.AuthRequest;
import com.example.assetmanager.service.user.registration.AuthResponse;
import com.example.assetmanager.service.user.registration.RegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request){

        Users user = Users.builder()
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .enabled(true)
            .locked(false)
            .role(Role.EMPLOYEE)
            .build();
        userRepo.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
            .token(jwtToken)
            .build();
    }

    public AuthResponse login(AuthRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        ));
        var user = userRepo.findByEmail(request.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
            .token(jwtToken)
            .build();
    }

    @Override
    public List<UserResponse> getAll() {
        List<Users> users = new ArrayList<>(userRepo.findAll());
        return UserResponse.of(users);
    }

    @Override
    public UserResponse getUser(Long id) {
        var user = userRepo.findById(id).orElseThrow(() -> new IllegalStateException("User not found"));
        return UserResponse.of(user);
    }
}
