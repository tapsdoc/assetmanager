package com.example.assetmanager.service.assethistory;

import java.util.List;

public interface AssetHistoryService {

    AssetHistoryResponse addAssetToHistory(AssetHistoryRequest request);
    List<AssetHistoryResponse> getAllAssetHistory();
    AssetHistoryResponse getHistoryForAsset(Long id);
}
