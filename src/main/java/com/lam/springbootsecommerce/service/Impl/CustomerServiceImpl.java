package com.lam.springbootsecommerce.service.Impl;

import com.lam.springbootsecommerce.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerServiceImpl implements UserDetailsService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    //Load by email instead of username
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new User("foo", "foo", new ArrayList<>());
//        UserDetails userDetails = customerRepository.findByEmail(email);
//        if (userDetails == null) {
//            throw new UsernameNotFoundException("Not found!");
//        }
//        return userDetails;
    }
}
