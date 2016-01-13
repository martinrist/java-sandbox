package com.martinrist.springInAction.spizza.domain;

public class CashOrChequePayment extends Payment {

    public CashOrChequePayment(double amount) {
        super(amount);
    }

    @Override
    public String toString() {
        return String.format("CASH / CHEQUE: $%.2f", getAmount());
    }
}
