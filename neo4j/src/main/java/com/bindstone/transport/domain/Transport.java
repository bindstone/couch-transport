package com.bindstone.transport.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import static org.neo4j.ogm.annotation.Relationship.*;

@NodeEntity
public class Transport {

    @Id
    private String numeroPVR;

    @Relationship(type = "COLORED", direction = OUTGOING)
    @JsonIgnoreProperties("transports")
    private Color color;

    @Relationship(type = "BUILD", direction = OUTGOING)
    @JsonIgnoreProperties("transports")
    private Manufacturer manufacturer;

    public String getNumeroPVR() {
        return numeroPVR;
    }

    public void setNumeroPVR(String numeroPVR) {
        this.numeroPVR = numeroPVR;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
