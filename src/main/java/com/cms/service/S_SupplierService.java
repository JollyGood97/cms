package com.cms.service;

import com.cms.entity.Employee;
import com.cms.entity.S_SupplierModel;
import com.cms.repository.S_SupplierRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class S_SupplierService {
    private final S_SupplierRepository supplierRepository;
    @Autowired
    public S_SupplierService(S_SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }
    public S_SupplierModel createSupplier(@NonNull final S_SupplierModel supplierModel) {
        return supplierRepository.save(supplierModel);
    }
    public List<S_SupplierModel> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public S_SupplierModel getSupplierById(String supplier_id) {
        return supplierRepository.findById(supplier_id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Supplier not found  " + supplier_id
        ));
    }
    public S_SupplierModel updateSupplier(String supplier_id, S_SupplierModel supplier) {
        Optional<S_SupplierModel> existingSupplier = supplierRepository.findById(supplier_id);
        if (existingSupplier.isPresent()) {
            return supplierRepository.save(supplier);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found - " + supplier_id);
        }
    }
    public void deleteSupplier(String id){
        Optional<S_SupplierModel> existingSupplier = supplierRepository.findById(id);
        if (existingSupplier.isPresent()) {
            supplierRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found - " + id);
        }
    }
}


