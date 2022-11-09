package com.cms.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "machinery-suppliers")
@Data
@EqualsAndHashCode(callSuper=true)
public class MachineryRental extends Vendor{
    private String machineryRentalId;
}
