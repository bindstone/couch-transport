package com.bindstone.transport.service;

import com.bindstone.transport.domain.Transport;
import com.bindstone.transport.domain.TransportCount;
import com.bindstone.transport.domain.TransportList;
import com.bindstone.transport.repository.TransportRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TransportService {

    private final TransportRepository transportRepository;

    public TransportService(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    public List<Transport> find() {

        Instant start = Instant.now();

        Iterable<Transport> iter = List.of();
        List<Transport> list = StreamSupport
                        .stream(iter.spliterator(), false)
                        .collect(Collectors.toList());

        Instant end = Instant.now();

        Duration interval = Duration.between(start, end);
        System.out.println("Execution time in seconds: " + interval.getSeconds());

        return list;
    }

    public  List<Transport> findAll() {

        Instant start = Instant.now();
        transportRepository.find1000();
        //Iterable<Transport> iter = transportRepository.findAll();
        //List<Transport> list = StreamSupport
        //        .stream(iter.spliterator(), false)
        //        .collect(Collectors.toList());
        List<Transport> list = transportRepository.find1000();

        Instant end = Instant.now();

        Duration interval = Duration.between(start, end);
        System.out.println("Execution time in seconds: " + interval.getSeconds());
        return list;
    }

    public List<TransportCount> getMostWantedConstructor() {
        Instant start = Instant.now();

        List<TransportCount> result = List.of();

        Instant end = Instant.now();

        Duration interval = Duration.between(start, end);
        System.out.println("Execution time in seconds: " + interval.getSeconds());
        return result;

    }

    public List<TransportList> getList() {
        Instant start = Instant.now();

        List<TransportList> result = List.of();

        Instant end = Instant.now();

        Duration interval = Duration.between(start, end);
        System.out.println("Execution time in seconds: " + interval.getSeconds());
        return result;
    }

    public List<TransportList> getListPage() {
        Instant start = Instant.now();

        List<TransportList> result = List.of();

        Instant end = Instant.now();

        Duration interval = Duration.between(start, end);
        System.out.println("Execution time in seconds: " + interval.getSeconds());
        return result;
    }
}
