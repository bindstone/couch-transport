package com.bindstone.transport.config;

import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableElasticsearchRepositories(basePackages = "com.bindstone.transport.repository")
public class ElasticConfig {

    public static final String INDEX_NAME = "public";
    public static final String INDEX_TYPE = "transport";

}

