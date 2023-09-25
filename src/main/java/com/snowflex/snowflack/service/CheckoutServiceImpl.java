package com.snowflex.snowflack.service;

import com.snowflex.snowflack.dao.CustomerRepository;
import com.snowflex.snowflack.dto.Purchase;
import com.snowflex.snowflack.dto.PurchaseResponse;
import com.snowflex.snowflack.entity.Order;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;


    public CheckoutServiceImpl ( CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the prder info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems

        //populate order with billingAddress and shippingAddress

        // populate customer with order

        // save to the databse

        // return a response

        return null;
    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID Version-4)
        // For details see : https://en.
    }
}
