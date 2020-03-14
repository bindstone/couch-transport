package com.bindstone.transport.repository;


import com.bindstone.transport.domain.Transport;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransportRepository {

    private final ElasticsearchOperations elasticsearchOperations;

    public TransportRepository(@Qualifier("elasticsearchTemplate") ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    public List<Transport> findAll() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().build();
        List<Transport> list = elasticsearchOperations.queryForList(searchQuery, Transport.class);
        return list;
    }
}
