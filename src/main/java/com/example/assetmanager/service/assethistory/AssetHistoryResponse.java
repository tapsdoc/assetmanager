package com.example.assetmanager.service.assethistory;

import com.example.assetmanager.domain.AssetHistory;
import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class AssetHistoryResponse {

    private Long id;
    private String assetName;
    private String employeeName;
    private String action;
    private String note;
    private String dateOfCreation;

    public static AssetHistoryResponse of(AssetHistory assetHistory) {
        Objects.requireNonNull(assetHistory);
        AssetHistoryResponse response = new AssetHistoryResponse();

        response.setAssetName(assetHistory.getAsset().getName());
        response.setEmployeeName(assetHistory.getEmployee().getFirstName() + " " + assetHistory.getEmployee().getLastName());
        response.setDateOfCreation(assetHistory.getDateOfCreation());
        response.setAction(assetHistory.getAction().name());
        response.setNote(assetHistory.getNote());
        return response;
    }

    public static List<AssetHistoryResponse> of(List<AssetHistory> assetHistories) {
        Objects.requireNonNull(assetHistories);
        return assetHistories.stream().map(AssetHistoryResponse::of).collect(Collectors.toList());
    }
}
