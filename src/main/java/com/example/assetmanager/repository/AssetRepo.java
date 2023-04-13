package com.example.assetmanager.repository;

import com.example.assetmanager.domain.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssetRepo extends JpaRepository<Asset, Long> {

    @Query("SELECT a FROM Asset a")
    @Override
    List<Asset> findAll();

    Asset findAssetByAssetId(String assetId);
}
