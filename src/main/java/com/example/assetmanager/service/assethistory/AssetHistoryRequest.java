package com.example.assetmanager.service.assethistory;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AssetHistoryRequest {

    private Long assetId;
    private Long employeeId;
    private String action;
    private String note;
}
