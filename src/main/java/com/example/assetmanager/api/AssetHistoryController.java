package com.example.assetmanager.api;


import com.example.assetmanager.service.assethistory.AssetHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/asset-history")
@RequiredArgsConstructor
public class AssetHistoryController {

    private final AssetHistoryService historyService;
}
