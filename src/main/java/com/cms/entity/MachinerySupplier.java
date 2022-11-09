package com.cms.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "machinery-suppliers")
public class MachinerySupplier extends Vendor{
    private String machinerySupplierId;

    public String getMachinerySupplierId() {
        return machinerySupplierId;
    }

    public void setMachinerySupplierId(String machinerySupplierId) {
        this.machinerySupplierId = machinerySupplierId;
    }
}
