package com.rev.cat.catservice.domain;

import com.rev.cat.catservice.domain.bootstrap.GenericDomain;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Getter
@Setter
@Document
public class Work extends GenericDomain {

    private String workAmount;
    private String workCode;
    private Date endDate;
    private Date initDate;
    private String paymentType;

    @DBRef
    private Customer customer;

    @DBRef
    private Position position;
}
