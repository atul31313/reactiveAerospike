package com.project.config;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.async.NioEventLoops;
import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.client.reactor.AerospikeReactorClient;
import com.aerospike.mapper.tools.ReactiveAeroMapper;
import io.micronaut.context.annotation.Factory;

import javax.inject.Singleton;

@Factory
public class AerospikeConfig {

    @Singleton
    public ReactiveAeroMapper reactiveAeroMapper(AerospikeProperties aerospikeProperties) {
        // Create a ClientPolicy.
        ClientPolicy policy = new ClientPolicy();
        // Set event loops to use in asynchronous commands.
        policy.eventLoops = new NioEventLoops(1);
        AerospikeClient client = new AerospikeClient(policy, aerospikeProperties.getHostname(), aerospikeProperties.getPort());
        return new ReactiveAeroMapper.Builder(new AerospikeReactorClient(client)).build();
    }
}
