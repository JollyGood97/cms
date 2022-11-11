package com.cms.entity;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "s_material")
public class S_MaterialModel extends S_SuppliesTypeModel {

}
