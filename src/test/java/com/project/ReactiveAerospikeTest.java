package com.project;

import com.project.config.CustomerClient;
import com.project.model.Customer;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

@MicronautTest
class ReactiveAerospikeTest {

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void shouldPublishToKafkaTopic() {
        CustomerClient customerClient = application.getApplicationContext().getBean(CustomerClient.class);
        customerClient.cacheCustomer(new Customer(1L, "Test", "asdf"));
    }
}
