package com.example.assetmanager.repository;

import com.example.assetmanager.domain.AssetHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AssetHistoryRepo extends JpaRepository<AssetHistory, Long> {

    @Query("SELECT a FROM AssetHistory a")
    @Override
    List<AssetHistory> findAll();
}
