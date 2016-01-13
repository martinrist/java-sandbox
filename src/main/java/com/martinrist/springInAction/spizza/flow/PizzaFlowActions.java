package com.martinrist.springInAction.spizza.flow;

import com.martinrist.springInAction.spizza.domain.Customer;
import com.martinrist.springInAction.spizza.service.CustomerNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class PizzaFlowActions {

    private static final Logger LOGGER = Logger.getLogger(PizzaFlowActions.class);

    public static final String PHONE_NUMBER_OF_THE_BEAST = "666";

    public Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException {

        if (phoneNumber == null || phoneNumber.equals(PHONE_NUMBER_OF_THE_BEAST)) {
            LOGGER.info("Unable to locate customer number with phone number " + phoneNumber);
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

    public boolean checkDeliveryArea(String zipCode) {
        boolean canDeliver = zipCode != null && zipCode.startsWith("1");
        LOGGER.info("Able to deliver to " + zipCode + "? : " + canDeliver);
        return canDeliver;
    }

    public void addCustomer(Customer customer) {
        LOGGER.info("Adding new customer : " + customer);
    }
}
