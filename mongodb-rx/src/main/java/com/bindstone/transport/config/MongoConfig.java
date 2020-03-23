package com.bindstone.transport.config;

import com.bindstone.transport.repository.TransportRepository;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import com.mongodb.reactivestreams.client.MongoClient;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackageClasses = TransportRepository.class)
public class MongoConfig extends AbstractReactiveMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "transport";
    }

    @Override
    @Bean
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }
}
