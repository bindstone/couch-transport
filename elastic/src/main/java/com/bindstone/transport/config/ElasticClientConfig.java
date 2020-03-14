package com.bindstone.transport.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ElasticClientConfig extends AbstractFactoryBean {

    private RestHighLevelClient restHighLevelClient;

    @Override
    public Class getObjectType() {
        return RestHighLevelClient.class;
    }

    @Override
    protected RestHighLevelClient createInstance() throws Exception {
        try {
            restHighLevelClient = new RestHighLevelClient(
                    RestClient.builder(new HttpHost("localhost", 9200, "http"),
                            new HttpHost("localhost", 9201, "http")
                    )
            );
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return restHighLevelClient;
    }

    @Override
    public void destroy() {
        try {
            restHighLevelClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
