package com.example.assetmanager.repository;

import com.example.assetmanager.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SupplierRepo extends JpaRepository<Supplier, Long> {

    Optional<Supplier> findSupplierByName(String name);
    @Query("SELECT s FROM Supplier s")
    @Override
    List<Supplier> findAll();
}
