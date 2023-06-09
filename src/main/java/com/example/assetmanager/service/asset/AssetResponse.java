package com.example.assetmanager.service.asset;

import com.example.assetmanager.domain.Asset;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class AssetResponse {

    private Long id;
    private String assetId;
    private String name;
    private String assetModelNumber;
    private String serialNumber;
    private String description;
    private String image;
    private Double price;
    private String dateOfPurchase;
    private String dateOfAssignment;
    private String dateOfManufacture;
    private String assetStatus;
    private String supplier;
    private String category;

    public static AssetResponse of(Asset asset) {
        Objects.requireNonNull(asset);
        AssetResponse response = new AssetResponse();
        response.setId(asset.getId());
        response.setAssetId(asset.getAssetId());
        response.setAssetModelNumber(asset.getAssetModelNumber());
        response.setSerialNumber(asset.getSerialNumber());
        response.setName(asset.getName());
        response.setDescription(asset.getDescription());
        response.setImage(asset.getImage());
        response.setPrice(asset.getUnitPrice());
        response.setDateOfPurchase(asset.getDateOfPurchase());
        response.setDateOfManufacture(asset.getDateOfManufacture());
        response.setDateOfAssignment(asset.getDateOfAssignment());
        response.setAssetStatus(asset.getAssetStatus().name());
        response.setSupplier(asset.getSupplier().getName());
        response.setCategory(asset.getCategory().getName());
        return response;
    }

    public static List<AssetResponse> of(List<Asset> assets) {
        return assets.stream().map(AssetResponse::of).collect(Collectors.toList());
    }
}
