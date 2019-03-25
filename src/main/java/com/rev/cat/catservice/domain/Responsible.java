package com.rev.cat.catservice.domain;

import com.rev.cat.catservice.domain.bootstrap.GenericDomain;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document
public class Responsible extends GenericDomain {

    @DBRef
    private SafetyEquipment safetyEquipment;

    @DBRef
    private Customer customer;
}
