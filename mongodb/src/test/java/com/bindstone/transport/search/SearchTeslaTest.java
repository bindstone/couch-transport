package com.bindstone.transport.search;

import com.bindstone.transport.service.TransportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@SpringBootTest
public class SearchTeslaTest {

    @Autowired
    TransportService transportService;

    @Test
    public void find_all_tesla() {
        Query query = new Query();
        query.addCriteria(Criteria.where("libelleMarque").is("TESLA"));
        System.out.println(transportService.find(query));
    }
}
