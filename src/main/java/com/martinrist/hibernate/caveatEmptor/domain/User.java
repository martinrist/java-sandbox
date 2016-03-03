package com.martinrist.hibernate.caveatEmptor.domain;


import com.martinrist.hibernate.caveatEmptor.converter.ZipcodeConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;

    private String username;
    private String firstname;
    private String lastname;

    @Convert(converter = ZipcodeConverter.class,
             attributeName = "zipcode")
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street",
                               column = @Column(name = "BILLING_STREET")),
            @AttributeOverride(name = "zipcode",
                    column = @Column(name = "BILLING_ZIPCODE", length = 5)),
            @AttributeOverride(name = "city",
                    column = @Column(name = "BILLING_CITY"))
    })
    @Convert(converter = ZipcodeConverter.class,
            attributeName = "zipcode")
    private Address billingAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    private BillingDetails defaultBilling;

    @OneToMany(mappedBy = "user")
    private Set<BillingDetails> billingDetails = new HashSet<>();

    public User() {

    }

    public static User newInstance(String username) {
        User user = new User();
        user.setUsername(username);
        return user;
    }

    public Long getId() {
        return id;
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

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public BigDecimal calculateShippingCosts(Address fromLocation) {
        // Empty implementation of business method
        return null;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

}
