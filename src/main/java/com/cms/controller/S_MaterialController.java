package com.cms.controller;
import com.cms.dto.S_MaterialDTO;
import com.cms.entity.S_MaterialModel;
import com.cms.service.S_MaterialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("supplies/materials")
public class S_MaterialController {
    private final S_MaterialService materialService;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    S_MaterialController(S_MaterialService materialService) {
        this.materialService = materialService;
    }
    @PostMapping
    public @ResponseBody
    S_MaterialDTO createMaterial(@RequestBody S_MaterialDTO materialDTO) {
        S_MaterialModel s_materialModel = mapper.map(materialDTO, S_MaterialModel.class);
        return mapper.map(materialService.createMaterial(s_materialModel), S_MaterialDTO.class);
    }
}

