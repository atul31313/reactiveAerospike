package com.project.repository;

import com.aerospike.mapper.tools.ReactiveAeroMapper;
import com.project.model.Customer;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CustomerRepository {
    private final ReactiveAeroMapper reactiveAeroMapper;

    @Inject
    public CustomerRepository(ReactiveAeroMapper reactiveAeroMapper) {
        this.reactiveAeroMapper = reactiveAeroMapper;
    }

    public Customer fetchRecord(Long customerId) {
        return reactiveAeroMapper.read(Customer.class, customerId).blockOptional().get();
    }
}
