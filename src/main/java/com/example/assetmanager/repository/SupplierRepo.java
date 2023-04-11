package com.example.assetmanager.repository;

import com.example.assetmanager.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<Supplier, Long> {
}
