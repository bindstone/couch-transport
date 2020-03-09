package com.bindstone.transport.controller;

import com.bindstone.transport.service.ImportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

@Controller
public class ImportController {

    private final ImportService importService;

    public ImportController(ImportService importService) {
        this.importService = importService;
    }
    @GetMapping("/import")
    public void importData() {
        try {
            importService.importData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
