package com.cms.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "machines")
@Data
@EqualsAndHashCode(callSuper=true)
public class Machine extends Resource{
    private String machineId;
}
