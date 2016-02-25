package com.martinrist.hibernate.caveatEmptor.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Bid implements Serializable {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;

    private BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdOn;

    private Item item;

    public Bid() {
    }

    public Long getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    void setItem(Item item) {
        this.item = item;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
