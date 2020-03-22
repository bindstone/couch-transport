package com.bindstone.transport.repository;

import com.bindstone.transport.domain.Transport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransportRepository {

    private final TransportFindAllRepository transportFindAllRepository;

    public TransportRepository(TransportFindAllRepository transportFindAllRepository) {
        this.transportFindAllRepository = transportFindAllRepository;
    }

    public List<Transport> find1000() {
        return transportFindAllRepository.find1000();
    }
}
