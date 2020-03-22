package com.bindstone.transport.service;

import com.bindstone.transport.domain.Transport;
import com.bindstone.transport.repository.TransportRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
public class TransportService {

    private final TransportRepository transportRepository;

    public TransportService(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    public List<Transport> find(String query) {

        Instant start = Instant.now();
        List<Transport> list = List.of();
        Instant end = Instant.now();

        Duration interval = Duration.between(start, end);
        System.out.println("Execution time in seconds: " + interval.getSeconds());

        return list;
    }

    public  List<Transport> findAll() {

        Instant start = Instant.now();
        List<Transport> list =  List.of();
        Instant end = Instant.now();

        Duration interval = Duration.between(start, end);
        System.out.println("Execution time in seconds: " + interval.getSeconds());

        return list;
    }
}
