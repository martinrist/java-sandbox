package com.martinrist.hibernate.caveatEmptor.domain;


import java.io.Serializable;
import java.math.BigDecimal;

public class User implements Serializable {

    private String username;
    private String firstname;
    private String lastname;

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public BigDecimal calculateShippingCosts(Address fromLocation) {
        // Empty implementation of business method
        return null;
    }

}
