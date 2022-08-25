package com.lam.springbootsecommerce.dao;

import com.lam.springbootsecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(@RequestParam("email") String email);
}
