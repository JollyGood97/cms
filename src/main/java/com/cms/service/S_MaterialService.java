package com.cms.service;
import com.cms.entity.S_MaterialModel;
import com.cms.repository.S_MaterialRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class S_MaterialService {
    private final S_MaterialRepository materialRepository;
    @Autowired
    S_MaterialService(S_MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }
    public S_MaterialModel createMaterial(@NonNull final S_MaterialModel materialModel) {
        return materialRepository.save(materialModel);
    }









}
