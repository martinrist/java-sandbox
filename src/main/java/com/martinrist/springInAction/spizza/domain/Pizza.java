package com.martinrist.springInAction.spizza.domain;

import org.apache.commons.lang.WordUtils;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza implements Serializable{

    public enum Size {

        SMALL, MEDIUM, LARGE, EXTRA_LARGE;

        @Override
        public String toString() {
            return WordUtils.capitalizeFully(name().replace('_', ' '));
        }
    }

    private Size size;
    private List<Topping> toppings;

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public Pizza() {
        size = Size.MEDIUM;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public double getPrice() {
        switch (size) {

            case SMALL:
                return 10;
            case MEDIUM:
                return 12;
            case LARGE:
                return 14;
            case EXTRA_LARGE:
                return 18;
            default:
                return 20;
        }

    }

    @Override
    public String toString() {
        String toppings = String.join(", ", getToppings().stream().map(Topping::toString).collect(Collectors.toList()));
        return String.format("%s - %s (price = $%.2f)", size, toppings, getPrice());
    }
}