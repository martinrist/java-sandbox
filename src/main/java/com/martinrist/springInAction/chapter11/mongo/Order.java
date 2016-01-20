package com.martinrist.springInAction.chapter11.mongo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.LinkedHashSet;

@Document
public class Order {

    @Id
    private String id;

    @Field("client")
    private String customer;

    private String type;

    private Collection<Item> items = new LinkedHashSet<>();

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object that) {
        boolean fieldsEqual = EqualsBuilder.reflectionEquals(this, that, new String[] {"items"});
        boolean itemsEqual = getItems().containsAll(((Order)that).getItems());
        return fieldsEqual && itemsEqual;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
