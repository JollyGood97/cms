package com.cms.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class MachinerySupplierDTO extends VendorDTO{
    private String machinerySupplierId;
}
