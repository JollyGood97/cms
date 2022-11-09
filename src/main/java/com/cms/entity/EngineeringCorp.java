package com.cms.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "engineering-corps")
@Data
@EqualsAndHashCode(callSuper=true)
public class EngineeringCorp extends Vendor {
    private String engCorpId;
}
