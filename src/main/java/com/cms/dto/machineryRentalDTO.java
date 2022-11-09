package com.cms.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class machineryRentalDTO extends VendorDTO{
    private String machineryRentalId;
}
