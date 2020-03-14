package com.bindstone.transport.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

@Configuration
public class ElasticConfig {

    public static final String INDEX_NAME = "public";
    public static final String INDEX_TYPE = "transport";

    private final RestHighLevelClient restHighLevelClient;

    public ElasticConfig(@Qualifier("elasticClientConfig") RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(restHighLevelClient);
    }
}

