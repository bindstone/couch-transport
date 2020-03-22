package com.bindstone.transport.service;

import com.bindstone.transport.domain.Color;
import com.bindstone.transport.domain.Manufacturer;
import com.bindstone.transport.domain.Transport;
import com.bindstone.transport.repository.ColorRepository;
import com.bindstone.transport.repository.ManufacturerRepository;
import com.bindstone.transport.repository.TransportRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ExportService {

    private final TransportRepository transportRepository;
    private final ColorRepository colorRepository;
    private final ManufacturerRepository manufacturerRepository;


    public ExportService(TransportRepository transportRepository, ColorRepository colorRepository, ManufacturerRepository manufacturerRepository) {
        this.transportRepository = transportRepository;
        this.colorRepository = colorRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Transactional
    public void clear() {
        transportRepository.deleteAll();
        colorRepository.deleteAll();
        manufacturerRepository.deleteAll();
    }

    @Transactional
    public void write(List<Map<String, Object>> list) {
        for (Map<String, Object> map : list) {
            Transport transport = new Transport();
            transport.setNumeroPVR((String) map.get("PVRNUM"));
            transport.setColor(color(map));
            transport.setManufacturer(manufacturer(map));
            transportRepository.save(transport);
        }
    }

    private Color color(Map<String, Object> map) {
        String col = (String) map.getOrDefault("COUL", "UNKNOWN");
        col = "".equals(col.trim()) ? "UNKNOWN" : col;

        Optional<Color> color = colorRepository.findById(col);
        if (color.isPresent()) {
            return color.get();
        } else {
            Color rtn = new Color();
            rtn.setName(col);
            return colorRepository.save(rtn);
        }
    }

    private Manufacturer manufacturer(Map<String, Object> map) {
        Optional<Manufacturer> color = manufacturerRepository.findById((String) map.get("LIBMRQ"));
        if (color.isPresent()) {
            return color.get();
        } else {
            Manufacturer rtn = new Manufacturer();
            rtn.setCode((String) map.get("CODMRQ"));
            rtn.setName((String) map.get("LIBMRQ"));
            return manufacturerRepository.save(rtn);
        }
    }

}
