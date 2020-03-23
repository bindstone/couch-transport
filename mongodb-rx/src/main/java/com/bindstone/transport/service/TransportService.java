package com.bindstone.transport.service;

import com.bindstone.transport.domain.Transport;
import com.bindstone.transport.domain.TransportCount;
import com.bindstone.transport.domain.TransportList;
import com.bindstone.transport.repository.TransportRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Service
public class TransportService {

    private final TransportRepository transportRepository;
    private final MongoTemplate mongoTemplate;

    public TransportService(TransportRepository transportRepository, MongoTemplate mongoTemplate) {
        this.transportRepository = transportRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public List<Transport> find(Query query) {

        Instant start = Instant.now();
        List<Transport> list = mongoTemplate.find(query, Transport.class);
        Instant end = Instant.now();

        Duration interval = Duration.between(start, end);
        System.out.println("Execution time in seconds: " + interval.getSeconds());

        return list;
    }

    public Flux<Transport> findAll() {

        Instant start = Instant.now();
        Flux<Transport> list = transportRepository.findAll();
        Instant end = Instant.now();

        Duration interval = Duration.between(start, end);
        System.out.println("Execution time in seconds: " + interval.getSeconds());

        return list;
    }

    public List<TransportCount> getMostWantedConstructor() {
        Instant start = Instant.now();

        Aggregation agg =newAggregation(
                group("libelleMarque").count().as("count"),
                project("count").and("libelleMarque").previousOperation(),
                sort(Sort.Direction.DESC, "count")
        );

        AggregationResults<TransportCount> groupResults
                = mongoTemplate.aggregate(agg, Transport.class, TransportCount.class);
        List<TransportCount> result = groupResults.getMappedResults();

        Instant end = Instant.now();

        Duration interval = Duration.between(start, end);
        System.out.println("Execution time in seconds: " + interval.getSeconds());
        return result;

    }

    public List<TransportList> getList() {
        Instant start = Instant.now();

        Aggregation agg =newAggregation(
                project("numeroPVR", "libelleMarque", "designationCommerciale", "couleur")
        );

        AggregationResults<TransportList> groupResults
                = mongoTemplate.aggregate(agg, Transport.class, TransportList.class);
        List<TransportList> result = groupResults.getMappedResults();

        Instant end = Instant.now();

        Duration interval = Duration.between(start, end);
        System.out.println("Execution time in seconds: " + interval.getSeconds());
        return result;
    }

    public List<TransportList> getListPage() {
        Instant start = Instant.now();

        Aggregation agg =newAggregation(
            skip(10L),
            limit(10L),
            sort(Sort.by("numeroPVR"))
        );

        project("numeroPVR", "libelleMarque", "designationCommerciale", "couleur");

        AggregationResults<TransportList> groupResults
                = mongoTemplate.aggregate(agg, Transport.class, TransportList.class);
        List<TransportList> result = groupResults.getMappedResults();

        Instant end = Instant.now();

        Duration interval = Duration.between(start, end);
        System.out.println("Execution time in seconds: " + interval.getSeconds());
        return result;
    }
}
