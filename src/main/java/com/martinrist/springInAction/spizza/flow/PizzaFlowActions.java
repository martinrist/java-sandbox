package com.martinrist.springInAction.spizza.flow;

import com.martinrist.springInAction.spizza.domain.Customer;
import com.martinrist.springInAction.spizza.service.CustomerNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class PizzaFlowActions {

    public static final String PHONE_NUMBER_OF_THE_BEAST = "666";

    public Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException {

        if (phoneNumber == null || phoneNumber.equals(PHONE_NUMBER_OF_THE_BEAST)) {
            throw new CustomerNotFoundException();
        }

        Customer customer = new Customer();
        customer.setName("Bananaman");
        customer.setAddress("29 Acacia Road");
        customer.setCity("London");
        customer.setZipCode("W1 1AA");
        customer.setPhoneNumber(phoneNumber);
        return customer;

    }
}
