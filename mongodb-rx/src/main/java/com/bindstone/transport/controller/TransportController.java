package com.bindstone.transport.controller;

import com.bindstone.transport.domain.Transport;
import com.bindstone.transport.service.TransportService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/api/v1/transport")
public class TransportController {

    private final TransportService transportService;

    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Transport> getAll() {
        System.out.println("Get All");
        return transportService.findAll()
                .delayElements(Duration.ofSeconds(0));
    }
}
