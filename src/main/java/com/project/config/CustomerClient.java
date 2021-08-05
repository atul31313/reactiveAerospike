package com.project.config;

import com.project.model.Customer;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface CustomerClient {
    @Topic("customer-details")
    void cacheCustomer(Customer customer);
}
