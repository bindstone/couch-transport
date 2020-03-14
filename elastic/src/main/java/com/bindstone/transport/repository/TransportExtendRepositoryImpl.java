package com.bindstone.transport.repository;


import com.bindstone.transport.domain.Transport;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

@Repository
public class TransportExtendRepositoryImpl {

    private final ElasticsearchOperations elasticsearchOperations;

    public TransportExtendRepositoryImpl(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    public List<Transport> findCustomAll() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQuery("COULEUR", "ROUGE"))
                .build();
        List<Transport> list = elasticsearchOperations.queryForList(searchQuery, Transport.class);
        return list;
    }
}
