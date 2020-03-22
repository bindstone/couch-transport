package com.bindstone.transport.service;

import com.bindstone.transport.repository.TransportRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImportService {

    private final ExportService exportService;

    public ImportService(ExportService exportService) {
        this.exportService = exportService;
    }

    public void importData() throws FileNotFoundException, XMLStreamException {
        System.out.println("Clear data:");
        exportService.clear();
        System.out.println("Start import data:");
        Instant start = Instant.now();
        importDataExec();
        Instant end = Instant.now();

        Duration interval = Duration.between(start, end);
        System.out.println("Execution time in seconds: " + interval.getSeconds());
    }

    private void importDataExec() throws FileNotFoundException, XMLStreamException {

        FileInputStream fi = new FileInputStream("/Users/qs/Documents/PROTO/couch-transport/data/parc-automobile-202003.xml");
        //FileInputStream fi = new FileInputStream("/Users/qs/Documents/PROTO/couch-transport/data/sample.xml");
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(fi);

        reader.nextEvent(); // Skip Title
        reader.nextEvent(); // Skip Header

        List list = new ArrayList< HashMap <String, Object>>();
        Map store = new HashMap<String, Object>();
        String key = null;
        Object data = null;

        while (reader.hasNext()) {
            XMLEvent nextEvent = reader.nextEvent();

            if (nextEvent.isStartElement()) {
                StartElement elem = nextEvent.asStartElement();
                if(!"VEHICLE".equals(elem.getName().toString())) {
                    key = elem.getName().toString();
                }
            }

            if (nextEvent.isCharacters()) {
                data = nextEvent.asCharacters().getData();
            }

            if (nextEvent.isEndElement()) {
                EndElement elem = nextEvent.asEndElement();
                if("VEHICLE".equals(elem.getName().toString())) {
                    store.put("_id", store.get("PVRNUM"));
                    list.add(store);

                    store = new HashMap <String,Object>();
                    if (list.size() > 100) {
                        exportService.write(list);
                        list.clear();
                        System.out.print(".");
                    }
                } else {
                    if (key != null && data != null) {
                        store.put(key,data);
                    }
                    key = null;
                    data = null;
                }
            }
        }
        exportService.write(list);
    }
}
