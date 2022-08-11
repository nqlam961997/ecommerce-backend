package com.lam.springbootsecommerce.dto;

import com.lam.springbootsecommerce.entity.Address;
import com.lam.springbootsecommerce.entity.Customer;
import com.lam.springbootsecommerce.entity.Order;
import com.lam.springbootsecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Address billingAddress;
    private Address shippingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
