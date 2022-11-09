package com.cms.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class MachineDTO extends ResourceDTO{
    private String machineId;
    private String category;
}
