package com.rev.cat.catservice.domain;

import com.rev.cat.catservice.domain.bootstrap.GenericDomain;
import com.rev.cat.catservice.domain.enums.IncidentSeverity;
import com.rev.cat.catservice.domain.enums.IncidentType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Getter
@Setter
@Document
public class Incident extends GenericDomain {

    private String name;
    private String description;
    private Date date;
    private IncidentType type;
    private IncidentSeverity severity;

    @DBRef
    private Customer customer;
}
