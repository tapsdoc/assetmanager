package com.example.assetmanager.service.supplier;

import com.example.assetmanager.domain.Supplier;
import com.example.assetmanager.repository.SupplierRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepo supplierRepo;

    @Override
    public Supplier addSupplier(SupplierRequest request) {

        Supplier supplier = Supplier.builder()
            .name(request.getName())
            .address(request.getAddress())
            .contactEmail(request.getContactEmail())
            .contactNumber(request.getContactNumber())
            .build();
        return supplierRepo.save(supplier);
    }

    @Override
    public Supplier getSupplier(Long id) {
        return supplierRepo.findById(id).orElseThrow(() -> new IllegalStateException("Supplier not found"));
    }

    @Override
    public Supplier editSupplier(Long id, SupplierRequest request) {

        var supplier = getSupplier(id);

        if (request.getName() != null) {
            supplier.setName(request.getName());
        }
        if (request.getAddress() != null) {
            supplier.setAddress(request.getAddress());
        }
        if (request.getContactEmail() != null) {
            supplier.setContactEmail(request.getContactEmail());
        }
        if (request.getContactNumber() != null) {
            supplier.setContactNumber(request.getContactNumber());
        }
        return supplierRepo.save(supplier);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalStateException("Supplier not found");
        }
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();
    }
}
