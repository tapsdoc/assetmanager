package com.example.assetmanager.repository;

import com.example.assetmanager.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c")
    @Override
    List<Category> findAll();
}
