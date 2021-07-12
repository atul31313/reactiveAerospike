package com.project.controller;

import com.project.model.Customer;
import com.project.service.CustomerService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import javax.inject.Inject;

@Controller("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Inject
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Get("/{customerId}")
    public Mono<Customer> get(@PathVariable Long customerId) {
//        System.out.println("Thread before read::::::" + Thread.currentThread().getName());
//        Mono<Customer> customer = customerService.getCustomer(customerId).map( (customer1) -> {
//            System.out.println("Thread after read111::::::" + Thread.currentThread().getName());
//            return customer1;
//        }).publishOn(Schedulers.newBoundedElastic(5,1,"Thread1")).map( (customer1) -> {
//            System.out.println("Thread after read222::::::" + Thread.currentThread().getName());
//            return customer1;
//        }).subscribeOn(Schedulers.newBoundedElastic(5,1,"Thread2")).map( (customer1) -> {
//            System.out.println("Thread after read333::::::" + Thread.currentThread().getName());
//            return customer1;
//        });
//        System.out.println("Thread after read::::::" + Thread.currentThread().getName());
//        return customer;
        return customerService.getCustomer(customerId);
    }
}
