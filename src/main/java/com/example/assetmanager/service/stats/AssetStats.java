package com.example.assetmanager.service.stats;

import com.example.assetmanager.repository.AssetRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor

public class AssetStats {

    private final AssetRepo assetRepo;

    public Map<String, Long> numberOfAssets() {
        Long count = assetRepo.numberOfAssets();
        Map<String, Long> result = new HashMap<>();
        result.put("Assets", count);
        return result;
    }

    public Map<String, Long> numberOfAssigned() {
        Long count = assetRepo.numberOfAssigned();
        Map<String, Long> result = new HashMap<>();
        result.put("Assigned", count);
        return result;
    }

    public Map<String, Long> numberOfUnassigned() {
        Long count = assetRepo.numberOfUnassigned();
        Map<String, Long> result = new HashMap<>();
        result.put("Unassigned", count);
        return result;
    }
}
