package com.martinrist.springInAction.chapter11.neo4j;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Neo4jConfig.class)
@Transactional
public class Neo4jIT {

    @Autowired
    private Neo4jOperations neo4j;

    private Order order;
    private Product product;

    @Before
    public void setUp() {
        order = new Order();
        order.setCustomer("Martin Rist");
        order.setType("personal");
        neo4j.save(order);

        product = new Product();
        product.setPrice(1.50);
        product.setProduct("Product 1");
        neo4j.save(product);
    }

    @After
    public void tearDown() {
        neo4j.delete(order);
        neo4j.delete(product);
    }

    @Test
    public void savingNewOrderSetsId() {
        assertThat(order.getId(), notNullValue());
    }

    @Test
    public void savingNewOrderThenRetrieving() {
        Order newOrder = neo4j.findOne(order.getId(), Order.class);
        assertThat(newOrder, equalTo(order));
    }

    @Test
    public void savingNewOrderCreatesSingleOrder() {
        assertThat(neo4j.count(Order.class), is(1L));
    }

    @Test
    public void createRelationship() {
        LineItem lineItem = neo4j.createRelationshipBetween(order, product, LineItem.class, "HAS_LINE_ITEM_FOR", false);
        lineItem.setQuantity(5);
        neo4j.save(lineItem);

        assertThat(lineItem, notNullValue());
        assertThat(lineItem.getOrder().getId(), is(order.getId()));
        assertThat(lineItem.getProduct().getId(), is(product.getId()));
    }


}
