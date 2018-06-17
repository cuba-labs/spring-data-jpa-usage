package com.company.sample.service;


import com.company.sample.entity.Customer;
import com.company.sample.entity.Order;

import java.util.List;

public interface OrderService {
    String NAME = "sample_OrderService";

    List<Order> getOrdersForCustomer(Customer customer);
}