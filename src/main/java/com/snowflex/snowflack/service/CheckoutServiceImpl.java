package com.snowflex.snowflack.service;

import com.snowflex.snowflack.dao.CustomerRepository;
import com.snowflex.snowflack.dto.Purchase;
import com.snowflex.snowflack.dto.PurchaseResponse;
import com.snowflex.snowflack.entity.Customer;
import com.snowflex.snowflack.entity.Order;
import com.snowflex.snowflack.entity.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

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
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        //populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        // save to the database
        customerRepository.save(customer);

        // return a response
        return  new PurchaseResponse(orderTrackingNumber);


    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID Version-4)
        // For details see : https://en.
        return UUID.randomUUID().toString();
    }
}
