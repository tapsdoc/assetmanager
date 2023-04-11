package com.example.assetmanager.service.statistics;

import com.example.assetmanager.repository.AssetRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssetStatisticsService {

    private final AssetRepo assetRepo;
}
