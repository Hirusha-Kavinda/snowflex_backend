package com.snowflex.snowflack.dto;

import com.snowflex.snowflack.entity.Address;
import com.snowflex.snowflack.entity.Customer;
import com.snowflex.snowflack.entity.Order;
import com.snowflex.snowflack.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem>orderItems;

}
