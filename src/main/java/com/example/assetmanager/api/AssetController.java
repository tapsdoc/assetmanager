package com.example.assetmanager.api;

import com.example.assetmanager.service.asset.AssetResponse;
import com.example.assetmanager.service.asset.AssetService;
import com.example.assetmanager.service.stats.AssetStats;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/asset/")
@RequiredArgsConstructor
public class AssetController {

    private final AssetService assetService;
    private final AssetStats assetStats;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public AssetResponse addAsset(
        @RequestParam String assetId,
        @RequestParam String name,
        @RequestParam String assetModelNumber,
        @RequestParam String serialNumber,
        @RequestParam Double price,
        @RequestParam Long categoryId,
        @RequestParam String dateOfPurchase,
        @RequestParam String dateOfManufacture,
        @RequestParam String description,
        @RequestParam String assetStatus,
        @RequestParam Long supplierId,
        @RequestParam(required = false) MultipartFile image
    ) throws IOException {
        return assetService.addAsset(
            assetId,
            name,
            assetModelNumber,
            serialNumber,
            price,
            categoryId,
            dateOfPurchase,
            dateOfManufacture,
            description,
            assetStatus,
            supplierId,
            image
        );
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<AssetResponse> getAllAssets() {
        return assetService.getAllAssets();
    }

    @GetMapping("/get-by-assetId/{assetId}")
    @ResponseStatus(HttpStatus.OK)
    public AssetResponse getAsset(@PathVariable String assetId) {
        return assetService.getAssetByAssetId(assetId);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        assetService.delete(id);
    }

    @GetMapping("/number-of-assets")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Long> numberOfAssets() {
        return assetStats.numberOfAssets();
    }

    @GetMapping("/number-of-assigned")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Long> numberOfAssigned() {
        return assetStats.numberOfAssigned();
    }

    @GetMapping("/number-of-unassigned")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Long> numberOfUnassigned() {
        return assetStats.numberOfUnassigned();
    }
}
