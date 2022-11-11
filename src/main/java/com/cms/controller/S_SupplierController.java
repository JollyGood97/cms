package com.cms.controller;

import com.cms.dto.EmployeeDTO;
import com.cms.dto.S_SupplierDTO;
import com.cms.entity.Employee;
import com.cms.entity.S_SupplierModel;
import com.cms.service.S_SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("common/supplier")
public class S_SupplierController {
    private final S_SupplierService supplierService;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    S_SupplierController(S_SupplierService supplierService) {
        this.supplierService = supplierService;
    }
    @PostMapping
    @PreAuthorize("hasRole('ROLE_SUPPLIER_MANAGER') or hasRole('SUPER_ADMIN')")
    public @ResponseBody
    S_SupplierDTO createSupplier(@RequestBody S_SupplierDTO supplierDTO) {
        S_SupplierModel supplierModel = mapper.map(supplierDTO, S_SupplierModel.class);
        return mapper.map(supplierService.createSupplier(supplierModel), S_SupplierDTO.class);
    }
    @GetMapping
    @PreAuthorize("hasRole('ROLE_SUPPLIER_MANAGER') or hasRole('SUPER_ADMIN')")
    public @ResponseBody
    List<S_SupplierDTO> getAllSuppliers() {
        List<S_SupplierModel> suppliers = supplierService.getAllSuppliers();
        return suppliers.stream().map(supplier ->
                mapper.map(supplier, S_SupplierDTO.class)
        ).collect(Collectors.toList());
    }
    @GetMapping("/{supplier_id}")
    @PreAuthorize("hasRole('ROLE_SUPPLIER_MANAGER') or hasRole('SUPER_ADMIN')")
    public @ResponseBody
    S_SupplierDTO getSupplierById(@PathVariable String supplier_id) {
        return mapper.map(supplierService.getSupplierById(supplier_id), S_SupplierDTO.class);
    }
    @PutMapping("/{supplier_id}")
    @PreAuthorize("hasRole('ROLE_SUPPLIER_MANAGER') or hasRole('SUPER_ADMIN')")
    public @ResponseBody
    S_SupplierDTO updateSupplier(@RequestBody S_SupplierDTO supplierDTO, @PathVariable String supplier_id) {
        S_SupplierModel supplierModel = mapper.map(supplierDTO, S_SupplierModel.class);
        return mapper.map(supplierService.updateSupplier(supplier_id, supplierModel), S_SupplierDTO.class);
    }
    @DeleteMapping("/{supplier_id}")
    @PreAuthorize("hasRole('ROLE_SUPPLIER_MANAGER') or hasRole('SUPER_ADMIN')")
    public void deleteSupplier(@PathVariable String supplier_id) {
        supplierService.deleteSupplier(supplier_id);
    }
}

