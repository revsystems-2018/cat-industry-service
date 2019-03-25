package com.rev.cat.catservice.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SafetyEquipmentRequestDTO {

    private String code;
    private String name;
    private String description;
    private Integer stock;
}
