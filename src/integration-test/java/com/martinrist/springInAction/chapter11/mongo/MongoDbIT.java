package com.martinrist.springInAction.chapter11.mongo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoConfig.class)
public class MongoDbIT {

    @Autowired
    private MongoOperations mongo;

    private Order order;

    @Before
    public void setUp() {
        order = new Order();
        order.setCustomer("Martin Rist");
        order.setType("personal");

        List<Item> items = new ArrayList<>();
        items.add(createItem("Product 1", 1, 2.99));
        items.add(createItem("Product 2", 3, 1.99));
        items.add(createItem("Product 3", 5, 8.99));
        order.setItems(items);
    }

    @After
    public void tearDown() {
        mongo.remove(order);
    }

    @Test
    public void savingOrderRemovesNullId() {
        assertThat(order.getId(), nullValue());
        mongo.save(order);
        assertThat(order.getId(), notNullValue());
    }

    @Test
    public void savingOrderThenRetrievingByIdReturnsMatchingOrder() {
        mongo.save(order);
        Order retrievedOrder = mongo.findById(order.getId(), Order.class);
        assertThat(order, equalTo(retrievedOrder));
    }

    private Item createItem(String product, int quantity, double price) {
        Item item = new Item();
        item.setProduct(product);
        item.setQuantity(quantity);
        item.setPrice(price);
        return item;
    }

}
