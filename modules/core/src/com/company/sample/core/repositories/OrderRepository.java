package com.company.sample.core.repositories;

import com.company.sample.entity.Customer;
import com.company.sample.entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, UUID> {

    List<Order> findByCustomer(Customer customer);
}
