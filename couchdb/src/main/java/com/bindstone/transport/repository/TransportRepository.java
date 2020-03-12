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
        QueryResult<Transport> result = db.query(query, Transport.class);
        return result.getDocs();
    }

    public void bulk(List<Map<String, Object>> data) {
        db.bulk(data);
    }
}
