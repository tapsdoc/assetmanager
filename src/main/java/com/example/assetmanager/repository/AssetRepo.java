package com.example.assetmanager.repository;

import com.example.assetmanager.domain.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepo extends JpaRepository<Asset, Long> {

    Asset findAssetByAssetId(String assetId);
}
