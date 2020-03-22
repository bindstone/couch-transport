package com.bindstone.transport.search;

import com.bindstone.transport.repository.TransportCategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SearchCategoriesTest {

    @Autowired
    TransportCategoryRepository transportCategoryRepository;

    @Test
    public void transportCategoryRepository() {
        transportCategoryRepository.findAll();
    }
}
