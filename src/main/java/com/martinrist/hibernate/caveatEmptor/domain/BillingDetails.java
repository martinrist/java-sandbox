package com.martinrist.hibernate.caveatEmptor.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BillingDetails {

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @NotNull
    private String owner;
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;

    public Long getId() {
        return id;
    }
}