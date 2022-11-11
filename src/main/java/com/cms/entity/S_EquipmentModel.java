package com.cms.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "s_equipment")
public class S_EquipmentModel extends S_SuppliesTypeModel {
    private boolean isRented;

    public boolean isRented() {
        return isRented;
    }
    public void setRented(boolean rented) {
        isRented = rented;
    }
}
