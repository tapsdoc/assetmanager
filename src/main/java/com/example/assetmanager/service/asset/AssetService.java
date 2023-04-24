package com.example.assetmanager.service.asset;

import com.example.assetmanager.service.supplier.SupplierRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface AssetService {

    AssetResponse addAsset(
        String assetId,
        String name,
        String assetModelNumber,
        String serialNumber,
        Double price,
        Long categoryId,
        String dateOfPurchase,
        String dateOfManufacture,
        String description,
        String assetStatus,
        Long supplierId,
        MultipartFile image
        ) throws IOException;

    AssetResponse editAsset(
        Long id,
        String assetId,
        String name,
        String assetModelNumber,
        String serialNumber,
        Double price,
        Long categoryId,
        String dateOfPurchase,
        String dateOfManufacture,
        String description,
        String assetStatus,
        Long supplierId,
        MultipartFile image
    ) throws IOException;

    AssetResponse getAssetByAssetId(String assetId);

    List<AssetResponse> getAllAssets();

    void delete(Long id);

    AssetResponse addCategoryToAsset(String assetId, Long categoryId);

    AssetResponse RemoveCategoryFromAsset(String assetId, Long categoryId);
}
