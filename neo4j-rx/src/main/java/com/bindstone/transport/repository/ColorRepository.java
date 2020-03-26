package com.bindstone.transport.repository;

import com.bindstone.transport.domain.Color;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ColorRepository extends Neo4jRepository<Color, String> {
}
