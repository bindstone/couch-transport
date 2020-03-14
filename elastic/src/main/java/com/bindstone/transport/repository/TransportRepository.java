package com.bindstone.transport.repository;

import com.bindstone.transport.domain.Transport;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TransportRepository extends ElasticsearchRepository<Transport, String>, TransportExtendRepository {
}
