package com.project.service;

import com.project.model.Customer;
import com.project.repository.CustomerRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Inject
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(Long customerId) {
        return customerRepository.fetchRecord(customerId);
    }
}
