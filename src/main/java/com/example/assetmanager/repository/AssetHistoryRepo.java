package com.example.assetmanager.repository;

import com.example.assetmanager.domain.AssetHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetHistoryRepo extends JpaRepository<AssetHistory, Long> {
}
