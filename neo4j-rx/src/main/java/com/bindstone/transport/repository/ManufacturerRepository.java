package com.bindstone.transport.repository;

import com.bindstone.transport.domain.Manufacturer;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ManufacturerRepository extends Neo4jRepository<Manufacturer, String> {
}
