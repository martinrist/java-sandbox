package com.martinrist.hibernate.caveatEmptor.domain;

import java.util.Objects;

public abstract class Zipcode {

    private String value;

    public Zipcode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zipcode zipCode = (Zipcode) o;
        return Objects.equals(value, zipCode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
