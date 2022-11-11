package com.cms.repository;
import com.cms.entity.S_SupplierModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface S_SupplierRepository extends MongoRepository<S_SupplierModel, String> {
    @Override
    List<S_SupplierModel> findAll();
    Optional<S_SupplierModel> findById(final String supplier_id);
}
