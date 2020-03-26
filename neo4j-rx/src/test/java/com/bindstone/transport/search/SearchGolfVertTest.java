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
        String query = "{" +
                "   \"selector\": {" +
                "      \"LIBMRQ\": \"VOLKSWAGEN\"," +
                "      \"COUL\": \"VERT\"" +
                "   }," +
                "   \"limit\": 50000000" +
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
