package com.martinrist.springInAction.chapter11.neo4j;

import org.springframework.data.neo4j.annotation.*;

@RelationshipEntity(type="HAS_LINE_ITEM_FOR")
public class LineItem {

    @GraphId
    private Long id;

    @StartNode
    @Fetch
    private Order order;

    @EndNode
    @Fetch
    private Product product;

    private int quantity;

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
