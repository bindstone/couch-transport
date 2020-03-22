package com.bindstone.transport.repository;

import com.bindstone.transport.config.ElasticConfig;
import com.bindstone.transport.domain.Transport;
import com.bindstone.transport.mapper.TransportMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class TransportFindAllRepository {

    private final ElasticsearchOperations elasticsearchOperations;
    private final RestHighLevelClient restHighLevelClient;
    private final ObjectMapper objectMapper;

    public TransportFindAllRepository(ElasticsearchOperations elasticsearchOperations, RestHighLevelClient restHighLevelClient, ObjectMapper objectMapper) {
        this.elasticsearchOperations = elasticsearchOperations;
        this.restHighLevelClient = restHighLevelClient;
        this.objectMapper = objectMapper;
    }

    public List<Transport> find1000() {

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.size(1000); // Max of results on return !!!

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.source(searchSourceBuilder);
        searchRequest.indices(ElasticConfig.INDEX_NAME);

        try {
            SearchResponse response = restHighLevelClient
                    .search(searchRequest, RequestOptions.DEFAULT);
            SearchHit[] hits = response.getHits().getHits();

            return TransportMapper.toTransport(hits, objectMapper);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return List.of();
    }


}
