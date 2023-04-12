package com.example.assetmanager.service.supplier;

import com.example.assetmanager.domain.Supplier;

import java.util.List;

public interface SupplierService {

    Supplier addSupplier(SupplierRequest request);
    Supplier getSupplier(Long id);
    Supplier editSupplier(Long id, SupplierRequest request);
    void delete(Long id);
    List<Supplier> getAllSuppliers();
}
