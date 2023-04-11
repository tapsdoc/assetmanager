package com.example.assetmanager.service.assethistory;

import com.example.assetmanager.common.Action;
import com.example.assetmanager.domain.Asset;
import com.example.assetmanager.domain.AssetHistory;
import com.example.assetmanager.domain.Employee;
import com.example.assetmanager.repository.AssetHistoryRepo;
import com.example.assetmanager.repository.AssetRepo;
import com.example.assetmanager.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssetHistoryServiceImpl implements AssetHistoryService {

    private final AssetHistoryRepo assetHistoryRepo;
    private final AssetRepo assetRepo;
    private final EmployeeRepo employeeRepo;
    @Override
    public AssetHistoryResponse addAssetToHistory(AssetHistoryRequest request) {

        Optional<Asset> asset = assetRepo.findById(request.getAssetId());
        Optional<Employee> employee = employeeRepo.findById(request.getEmployeeId());
        AssetHistory history = new AssetHistory();

        if (asset.isEmpty()) {
            throw new IllegalStateException("Asset not found");
        }
        history.setAsset(asset.get());
        if (employee.isEmpty()) {
            throw new IllegalStateException("Employee not found");
        }
        history.setEmployee(employee.get());
        history.setDateOfCreation(request.getDateOfCreation());
        history.setAction(Action.valueOf(request.getAction()));
        history.setNote(request.getNote());

        var savedHistory = assetHistoryRepo.save(history);
        return AssetHistoryResponse.of(savedHistory);
    }

    @Override
    public List<AssetHistoryResponse> getAllAssetHistory() {
        return null;
    }

    @Override
    public AssetHistoryResponse getHistoryForAsset(Long id) {
        return null;
    }
}
