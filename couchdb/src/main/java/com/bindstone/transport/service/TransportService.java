package com.bindstone.transport.service;

import com.bindstone.transport.domain.Transport;
import com.bindstone.transport.repository.TransportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportService {

    private final TransportRepository transportRepository;

    public TransportService(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    public List<Transport> find(String query) {
        return transportRepository.find(query);
    }

    public  List<Transport> findAll() {
        return transportRepository.findAll();
    }
}
