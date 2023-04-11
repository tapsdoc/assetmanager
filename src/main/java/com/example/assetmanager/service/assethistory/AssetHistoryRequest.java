package com.example.assetmanager.service.assethistory;

import lombok.Data;

@Data
public class AssetHistoryRequest {

    private Long assetId;
    private Long employeeId;
    private String action;
    private String note;
    private String dateOfCreation;
}
