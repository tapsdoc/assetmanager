package com.example.assetmanager.service.asset;

import com.example.assetmanager.domain.Supplier;
import com.example.assetmanager.service.supplier.SupplierRequest;
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
    private LocalDate dateOfPurchase;
    private LocalDate dateOfAssignment;
    private LocalDate dateOfManufacture;
    private String assetStatus;
    private SupplierRequest supplier;
    private Long categoryId;
}
