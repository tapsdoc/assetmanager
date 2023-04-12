package com.example.assetmanager.security;

import com.example.assetmanager.common.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/**").permitAll()
                .anyRequest().permitAll()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}

/*
.requestMatchers("/api/v1/department/**").hasAnyRole(Role.ADMIN.name(), Role.SUPER_USER.name(), Role.MANAGER.name())
                .requestMatchers("/api/v1/employee/**").hasAnyRole(Role.ADMIN.name(), Role.SUPER_USER.name(), Role.MANAGER.name())
                .requestMatchers("/api/v1/asset/**").hasAnyRole(Role.ADMIN.name(), Role.SUPER_USER.name())
                .requestMatchers("/api/v1/asset-history/**").hasAnyRole(Role.ADMIN.name(), Role.SUPER_USER.name(), Role.MANAGER.name())
                .requestMatchers("/api/v1/department/**").hasAnyRole(Role.ADMIN.name(), Role.SUPER_USER.name())
                .requestMatchers("/api/v1/user/**").hasAnyRole(Role.ADMIN.name(), Role.SUPER_USER.name())
 */