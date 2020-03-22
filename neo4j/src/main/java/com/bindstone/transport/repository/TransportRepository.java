package com.bindstone.transport.repository;

import com.bindstone.transport.domain.Transport;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TransportRepository extends Neo4jRepository<Transport, String> {
}
