package com.cms.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class MachineryRentalDTO extends VendorDTO{
    private String machineryRentalId;
}
