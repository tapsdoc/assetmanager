package com.example.assetmanager.service.asset;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AssetRequest {

    private String assetId;
    private String name;
    private String assetModelNumber;
    private String serialNumber;
    private String description;
    private String image;
    private Double price;
    private LocalDateTime dateOfPurchase;
    private LocalDateTime dateOfAssignment;
    private LocalDate dateOfManufacture;
    private String assetStatus;
    private Long supplierId;
    private Long categoryId;
}
