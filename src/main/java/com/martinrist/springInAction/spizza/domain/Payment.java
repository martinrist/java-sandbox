package com.martinrist.springInAction.spizza.domain;

import java.io.Serializable;

public abstract class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    private double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
