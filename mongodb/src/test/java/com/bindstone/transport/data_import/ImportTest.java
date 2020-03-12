package com.bindstone.transport.data_import;

import com.bindstone.transport.service.ImportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

@SpringBootTest
public class ImportTest {

    @Autowired
    ImportService importService;

    //@Test()
    public void importAll() throws FileNotFoundException, XMLStreamException {
        importService.importData();
    }
}
