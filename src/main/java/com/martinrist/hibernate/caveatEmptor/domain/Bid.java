package com.martinrist.hibernate.caveatEmptor.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Bid implements Serializable {

    private BigDecimal amount;
    private Date createdOn;
    private Item item;

    public Item getItem() {
        return item;
    }

    void setItem(Item item) {
        this.item = item;
    }

    public Bid() {
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
