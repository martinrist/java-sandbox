package com.martinrist.springInAction.spizza.domain;

import org.apache.commons.lang.WordUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public enum PaymentType implements Serializable {

    CASH, CHEQUE, CREDIT_CARD;

    public static List<PaymentType> asList() {
        PaymentType[] all = PaymentType.values();
        return Arrays.asList(all);
    }

    @Override
    public String toString() {
        return WordUtils.capitalizeFully(name().replace('_', ' '));
    }

}