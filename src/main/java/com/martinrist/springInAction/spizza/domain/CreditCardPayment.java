package com.martinrist.springInAction.spizza.domain;

public class CreditCardPayment extends Payment {

    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public String toString() {
        return String.format("CREDIT: $%.2f", getAmount());
    }
}
