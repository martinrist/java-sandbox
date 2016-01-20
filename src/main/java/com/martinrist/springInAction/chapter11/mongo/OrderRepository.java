package com.martinrist.springInAction.chapter11.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    // This just gets the standard Mongo repository methods

    // These methods are implemented automatically by Spring Data without
    // anything else, as they follow the naming convention
    List<Order> findByCustomer(String c);
    List<Order> findByCustomerLike(String c);
    List<Order> findByCustomerAndType(String c, String t);
    List<Order> findByCustomerLikeAndType(String c, String t);

    // This method is based on a specific query
    @Query("{'customer': 'Chuck Wagon', 'type' : ?0}")
    List<Order> findChucksOrders(String t);

}