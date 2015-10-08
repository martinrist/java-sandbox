package com.martinrist.thinkingInJava.strings;

import java.util.Scanner;

public class DataHolder {

    private int intValue;
    private long longValue;
    private float floatValue;
    private double doubleValue;
    private String stringValue;

    public DataHolder(String initialValue) {

        Scanner s = new Scanner(initialValue);

        this.intValue = s.nextInt();
        this.longValue = s.nextLong();
        this.floatValue = s.nextFloat();
        this.doubleValue = s.nextDouble();
        this.stringValue = s.next();

    }

    public String getStringValue() {
        return stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public long getLongValue() {
        return longValue;
    }

    public float getFloatValue() {
        return floatValue;
    }

    public double getDoubleValue() {
        return doubleValue;
    }



}
