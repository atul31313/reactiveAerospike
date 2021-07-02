package com.project.controller;

import com.project.model.Customer;
import com.project.service.CustomerService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import javax.inject.Inject;

@Controller("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Inject
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Get("/{customerId}")
    public Customer get(@PathVariable Long customerId) {
        return customerService.getCustomer(customerId);
    }
}
