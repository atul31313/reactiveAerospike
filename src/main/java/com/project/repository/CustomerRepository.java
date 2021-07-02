package com.project.repository;

import com.project.model.Customer;

import javax.inject.Singleton;

@Singleton
public class CustomerRepository {
    public Customer fetchRecord(Long customerId) {
        return new Customer(customerId, "Test123", "9940456027");
    }
}
