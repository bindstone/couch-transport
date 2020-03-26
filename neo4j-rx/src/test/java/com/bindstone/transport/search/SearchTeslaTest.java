package com.bindstone.transport.search;

import com.bindstone.transport.service.TransportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SearchTeslaTest {

    @Autowired
    TransportService transportService;

    @Test
    public void find_all_tesla() {
        String query = "{" +
                "   \"selector\": {" +
                "      \"LIBMRQ\": {" +
                "         \"$eq\": \"TESLA\"" +
                "      }" +
                "   }" +
                "}";
        System.out.println(transportService.find(query));
    }

    // http://127.0.0.1:5984/_utils/#database/transport/_index

    /**
     * {
     *    "index": {
     *       "fields": [
     *          "LIBMRQ"
     *       ]
     *    },
     *    "name": "libmrq-json-index",
     *    "type": "json"
     * }
     */

}
