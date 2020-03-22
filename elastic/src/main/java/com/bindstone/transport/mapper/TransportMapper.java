package com.bindstone.transport.mapper;

import com.bindstone.transport.domain.Transport;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.search.SearchHit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransportMapper {

    public static List<Transport> toTransport(SearchHit[] hits, ObjectMapper objectMapper) {
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
    }
}
