package com.bindstone.transport.search;

import com.bindstone.transport.service.TransportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SearchGolfVertTest {

    @Autowired
    TransportService transportService;

    @Test
    public void find_all_Golf_Vert() {
        System.out.println(transportService.find());
    }
}
