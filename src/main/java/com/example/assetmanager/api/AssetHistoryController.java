package com.example.assetmanager.api;


import com.example.assetmanager.service.assethistory.AssetHistoryResponse;
import com.example.assetmanager.service.assethistory.AssetHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/asset-history")
@RequiredArgsConstructor
public class AssetHistoryController {

    private final AssetHistoryService historyService;

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AssetHistoryResponse getHistoryForAsset(@PathVariable Long id) {
        return historyService.getHistoryForAsset(id);
    }
}
