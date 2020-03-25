package com.bindstone.transport.search;

import com.bindstone.transport.domain.Transport;
import com.bindstone.transport.service.TransportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SearchAllTest {

    @Autowired
    TransportService transportService;

    @Test
    public void findAll() {
        Flux<Transport> flux = transportService.findAll();
        //flux.subscribe(System.out::println);

        List collect = new ArrayList();
        flux.toIterable().forEach(collect::add);
        System.out.println(collect.size());

    }
}
