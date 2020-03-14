package com.bindstone.transport.repository;


import com.bindstone.transport.config.ElasticConfig;
import com.bindstone.transport.domain.Transport;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.script.mustache.SearchTemplateRequest;
import org.elasticsearch.script.mustache.SearchTemplateResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

@Repository
public class TransportExtendRepositoryImpl implements TransportExtendRepository {

    private final ElasticsearchOperations elasticsearchOperations;
    private final RestHighLevelClient restHighLevelClient;
    private final ObjectMapper objectMapper;

    public TransportExtendRepositoryImpl(ElasticsearchOperations elasticsearchOperations, RestHighLevelClient restHighLevelClient, ObjectMapper objectMapper) {
        this.elasticsearchOperations = elasticsearchOperations;
        this.restHighLevelClient = restHighLevelClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Transport> findCustomAll() {

        SearchTemplateRequest request = new SearchTemplateRequest();
        request.setRequest(new SearchRequest(ElasticConfig.INDEX_NAME));

        request.setScriptType(ScriptType.INLINE);
        request.setScript(
                "{" +
                        "  \"query\": { \"match\" : { \"{{field}}\" : \"{{value}}\" } }," +
                        "  \"size\" : \"{{size}}\"" +
                        "}");

        Map<String, Object> scriptParams = new HashMap<>();
        scriptParams.put("field", "couleur");
        scriptParams.put("value", "rouge");
        scriptParams.put("size", 5);
        request.setScriptParams(scriptParams);

        try {
            SearchTemplateResponse templateResponse = restHighLevelClient.searchTemplate(request, RequestOptions.DEFAULT);
            SearchResponse response = templateResponse.getResponse();
            SearchHit[] hits = response.getHits().getHits();

            return Arrays
                .stream(hits)
                .map(doc -> {
                    String source = doc.getSourceAsString();
                    try {
                        return objectMapper.readValue(source, Transport.class);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                        return null;
                    }
                }).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    private List<Transport> findCustomAllT() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQuery("COULEUR", "ROUGE"))
                .build();
        List<Transport> list = elasticsearchOperations.queryForList(searchQuery, Transport.class);
        return list;
    }
}
