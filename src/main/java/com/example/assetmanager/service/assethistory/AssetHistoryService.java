package com.example.assetmanager.service.assethistory;

import com.example.assetmanager.domain.AssetHistory;

import java.util.List;

public interface AssetHistoryService {

    List<AssetHistory> getAllAssetHistory();
    AssetHistoryResponse getHistoryForAsset(Long id);
}
