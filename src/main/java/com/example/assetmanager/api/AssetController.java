package com.example.assetmanager.api;

import com.example.assetmanager.service.asset.AssetRequest;
import com.example.assetmanager.service.asset.AssetResponse;
import com.example.assetmanager.service.asset.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/api/v1/asset/")
@RequiredArgsConstructor
public class AssetController {

    private final AssetService assetService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public AssetResponse addAsset(@RequestBody AssetRequest request) {
        return assetService.addAsset(request);
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
}
