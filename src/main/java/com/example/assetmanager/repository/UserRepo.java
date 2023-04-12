package com.example.assetmanager.repository;

import com.example.assetmanager.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface UserRepo extends JpaRepository<Users, Long> {

    Optional<Users> findByUsername(String username);
    Optional<Users> findByEmail(String email);
    @Transactional
    @Modifying
    @Query(value = "UPDATE Users u " +
            "SET u.enabled = TRUE WHERE u.email = ?1")
    void enableUser(String email);
}
