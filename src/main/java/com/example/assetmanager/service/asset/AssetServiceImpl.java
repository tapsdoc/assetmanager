package com.example.assetmanager.service.asset;

import com.example.assetmanager.common.Action;
import com.example.assetmanager.common.AssetStatus;
import com.example.assetmanager.domain.Asset;
import com.example.assetmanager.domain.AssetHistory;
import com.example.assetmanager.domain.Category;
import com.example.assetmanager.domain.Supplier;
import com.example.assetmanager.repository.AssetHistoryRepo;
import com.example.assetmanager.repository.AssetRepo;
import com.example.assetmanager.repository.CategoryRepo;
import com.example.assetmanager.repository.SupplierRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {

    private final AssetRepo assetRepo;
    private final AssetHistoryRepo assetHistoryRepo;
    private final CategoryRepo categoryRepo;
    private final SupplierRepo supplierRepo;

    @Override
    public AssetResponse addAsset(AssetRequest request) {
        Optional<Category> category = categoryRepo.findById(request.getCategoryId());
        if (category.isEmpty()) {
            throw new IllegalStateException("Category is not found");
        }

        Supplier supplier = Supplier.builder()
            .name(request.getSupplier().getName())
            .address(request.getSupplier().getAddress())
            .contactEmail(request.getSupplier().getContactEmail())
            .contactNumber(request.getSupplier().getContactNumber())
            .build();
        supplierRepo.save(supplier);

        Asset asset = Asset.builder()
            .assetId(request.getAssetId())
            .name(request.getName())
            .assetModelNumber(request.getAssetModelNumber())
            .description(request.getDescription())
            .serialNumber(request.getSerialNumber())
            .supplier(supplier)
            .dateOfPurchase(request.getDateOfPurchase())
            .description(request.getDescription())
            .unitPrice(request.getPrice())
            .dateOfManufacture(request.getDateOfManufacture())
            .category(category.get())
            .assetStatus(AssetStatus.valueOf(request.getAssetStatus()))
            .build();

        var savedAsset = assetRepo.save(asset);

        AssetHistory history = AssetHistory.builder()
            .asset(savedAsset)
            .employee(null)
            .actionDate(LocalDateTime.now())
            .action(Action.CREATED)
            .isAssigned(false)
            .isReturned(true)
            .build();

        assetHistoryRepo.save(history);
        return AssetResponse.of(savedAsset);
    }

    @Override
    public AssetResponse editAsset(Long id, AssetRequest request) {

        Asset asset = assetRepo.findById(id).orElseThrow(() -> new IllegalStateException("Asset not found"));
        Optional<Category> category = categoryRepo.findById(request.getCategoryId());

        if (request.getAssetId() != null) {
            asset.setAssetId(request.getAssetId());
        }
        if (request.getName() != null) {
            asset.setName(request.getName());
        }
        if (request.getAssetModelNumber() != null) {
            asset.setAssetModelNumber(request.getAssetModelNumber());
        }
        if (request.getSerialNumber() != null) {
            asset.setSerialNumber(request.getSerialNumber());
        }
        if (request.getDateOfManufacture() != null) {
            asset.setDateOfManufacture(request.getDateOfManufacture());
        }
        if (request.getDateOfPurchase() != null) {
            asset.setDateOfPurchase(request.getDateOfPurchase());
        }
        if (request.getAssetStatus() != null) {
            asset.setAssetStatus(AssetStatus.valueOf(request.getAssetStatus()));
        }
        if (request.getDescription() != null) {
            asset.setDescription(request.getDescription());
        }
        if (request.getCategoryId() != null){
            if (category.isEmpty()) {
                throw new IllegalStateException("Category is not found");
            }
            asset.setCategory(category.get());
        }
        var updatedAsset = assetRepo.save(asset);
        return AssetResponse.of(updatedAsset);
    }

    @Override
    public AssetResponse getAssetByAssetId(String assetId) {
        Asset asset = assetRepo.findAssetByAssetId(assetId);
        return AssetResponse.of(asset);
    }

    @Override
    public List<AssetResponse> getAllAssets() {
        List<Asset> assets = new ArrayList<>(assetRepo.findAll());
        return AssetResponse.of(assets);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalStateException("Id cannot be null");
        }
        assetRepo.deleteById(id);
    }

    @Override
    public AssetResponse addCategoryToAsset(String assetId, Long categoryId) {
        Asset asset = assetRepo.findAssetByAssetId(assetId);
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new IllegalStateException("Category not found"));

        if (Objects.nonNull(asset.getCategory())) {
            throw new IllegalArgumentException("Asset already has a category");
        }
        asset.setCategory(category);
        return AssetResponse.of(asset);
    }

    @Override
    public AssetResponse RemoveCategoryFromAsset(String assetId, Long categoryId) {
        Asset asset = assetRepo.findAssetByAssetId(assetId);

        if (!Objects.nonNull(asset.getCategory())) {
            throw new IllegalArgumentException("Asset does not have a category to remove");
        }
        asset.setCategory(null);
        return AssetResponse.of(asset);
    }
}
