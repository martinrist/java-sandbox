package com.martinrist.hibernate.caveatEmptor.domain;


import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class BillingDetails {

    @NotNull
    private String owner;

}