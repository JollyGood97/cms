package com.cms.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class EngineeringCorpDTO extends VendorDTO{
    private String engCorpId;

}
