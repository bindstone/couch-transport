package com.bindstone.transport.repository;

import com.bindstone.transport.domain.Transport;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransportRepository extends ReactiveMongoRepository<Transport, String> {
}
