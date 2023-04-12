package com.example.assetmanager.service.user;

import com.example.assetmanager.domain.Users;
import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class UserResponse {

    private Long id;
    private String username;
    private String email;
    private String role;

    public static UserResponse of(Users users) {
        Objects.requireNonNull(users);
        UserResponse response = new UserResponse();

        response.setId(users.getId());
        response.setUsername(users.getUsername());
        response.setEmail(users.getEmail());
        response.setRole(users.getRole().name());
        return response;
    }

    public static List<UserResponse> of(List<Users> users) {
        return users.stream().map(UserResponse::of).collect(Collectors.toList());
    }
}
