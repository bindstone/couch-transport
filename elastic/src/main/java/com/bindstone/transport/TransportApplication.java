package com.bindstone.transport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class TransportApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransportApplication.class, args);
    }

}
