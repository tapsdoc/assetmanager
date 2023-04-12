package com.example.assetmanager.service.asset;

import java.util.List;

public interface AssetService {

    AssetResponse addAsset(AssetRequest request);
    AssetResponse editAsset(Long id, AssetRequest request);
    AssetResponse getAssetByAssetId(String assetId);
    List<AssetResponse> getAllAssets();
    void delete(Long id);
    AssetResponse addCategoryToAsset(String assetId, Long categoryId);

    AssetResponse RemoveCategoryFromAsset(String assetId, Long categoryId);
}
