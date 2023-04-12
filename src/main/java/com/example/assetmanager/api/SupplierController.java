package com.example.assetmanager.api;

import com.example.assetmanager.domain.Supplier;
import com.example.assetmanager.service.supplier.SupplierRequest;
import com.example.assetmanager.service.supplier.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/supplier")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Supplier addSupplier(@RequestBody SupplierRequest request) {
        return supplierService.addSupplier(request);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Supplier getSupplier(@PathVariable Long id) {
        return supplierService.getSupplier(id);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Supplier editSupplier(@PathVariable Long id, @RequestBody SupplierRequest request) {
        return supplierService.editSupplier(id, request);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        supplierService.delete(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }
}
