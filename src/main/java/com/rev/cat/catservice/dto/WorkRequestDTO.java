package com.rev.cat.catservice.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class WorkRequestDTO {
    private String workAmount;
    private String workCode;
    private String paymentType;

    private String positionId;
    private String employeeId;
}