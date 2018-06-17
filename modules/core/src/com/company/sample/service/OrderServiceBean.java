package com.company.sample.service;

import com.company.sample.core.Repositories;
import com.company.sample.core.repositories.OrderRepository;
import com.company.sample.entity.Customer;
import com.company.sample.entity.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service(OrderService.NAME)
public class OrderServiceBean implements OrderService {

    @Inject
    private Repositories repositories;

    @Override
    @Transactional
    public List<Order> getOrdersForCustomer(Customer customer) {
        OrderRepository orderRepository = repositories.get(OrderRepository.class);
        return orderRepository.findByCustomer(customer);
    }
}