package com.bindstone.transport.service;

import com.bindstone.transport.domain.Transport;
import com.bindstone.transport.repository.TransportRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
public class TransportService {

    private final TransportRepository transportRepository;
    private final MongoTemplate mongoTemplate;

    public TransportService(TransportRepository transportRepository, MongoTemplate mongoTemplate) {
        this.transportRepository = transportRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public List<Transport> find(Query query) {

        Instant start = Instant.now();
        List<Transport> list = mongoTemplate.find(query, Transport.class);
        Instant end = Instant.now();

        Duration interval = Duration.between(start, end);
        System.out.println("Execution time in seconds: " + interval.getSeconds());

        return list;
    }

    public  List<Transport> findAll() {

        Instant start = Instant.now();
        List<Transport> list = transportRepository.findAll();
        Instant end = Instant.now();

        Duration interval = Duration.between(start, end);
        System.out.println("Execution time in seconds: " + interval.getSeconds());

        return list;
    }
}
