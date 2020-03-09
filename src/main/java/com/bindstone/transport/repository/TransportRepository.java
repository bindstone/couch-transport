package com.bindstone.transport.repository;

import com.bindstone.transport.domain.Transport;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.query.QueryResult;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;

@Service
public class TransportRepository {

    private final Database db;

    public TransportRepository(Database db) {
        this.db = db;
    }

    public List<Transport> findAll() {
        String query = "{" +
                "   \"selector\": {" +
                "      \"_id\": {" +
                "         \"$gt\": null" +
                "      }" +
                "   }," +
                "   \"limit\": 50000000" +
                "}";
        return find(query);
    }

    public List<Transport> find(String query) {
        Instant start = Instant.now();
        QueryResult<Transport> result = db.query(query, Transport.class);
        Instant end = Instant.now();

        Duration interval = Duration.between(start, end);
        System.out.println("Execution query [" + query + "] in seconds: " + interval.getSeconds());
        return result.getDocs();
    }

    public void bulk(List<Map<String, Object>> data) {
        Instant start = Instant.now();
        db.bulk(data);
        Instant end = Instant.now();

        Duration interval = Duration.between(start, end);
        System.out.println("Execution time in seconds: " + interval.getSeconds());
    }

}
