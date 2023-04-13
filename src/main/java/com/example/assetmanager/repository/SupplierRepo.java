package com.example.assetmanager.repository;

import com.example.assetmanager.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepo extends JpaRepository<Supplier, Long> {

    Optional<Supplier> findSupplierByName(String name);
}
