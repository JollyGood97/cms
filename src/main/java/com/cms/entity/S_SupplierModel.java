package com.cms.entity;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "s_suppliers")
public class S_SupplierModel {
    private String supplier_id;
    private String supplier_name;
    private String supplier_address;
    private String supplier_contact_no;
    private String supplier_account;
    private String supplier_remark;
}
