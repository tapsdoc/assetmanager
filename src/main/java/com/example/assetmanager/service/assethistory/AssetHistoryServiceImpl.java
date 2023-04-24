package com.example.assetmanager.service.assethistory;

import com.example.assetmanager.domain.AssetHistory;
import com.example.assetmanager.repository.AssetHistoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssetHistoryServiceImpl implements AssetHistoryService {

    private final AssetHistoryRepo assetHistoryRepo;

    @Override
    public List<AssetHistory> getAllAssetHistory() {
        return assetHistoryRepo.findAll();
    }

    @Override
    public AssetHistoryResponse getHistoryForAsset(Long id) {
        var history = assetHistoryRepo.findById(id).orElseThrow(() -> new IllegalStateException("History of asset not found"));
        return AssetHistoryResponse.of(history);
    }
}