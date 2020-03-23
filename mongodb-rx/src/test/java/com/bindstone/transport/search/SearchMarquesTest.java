package com.bindstone.transport.search;

import com.bindstone.transport.service.TransportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SearchMarquesTest {

    @Autowired
    TransportService transportService;

    @Test
    public void findMarques() {
        System.out.println(transportService.getMostWantedConstructor());
    }
}
