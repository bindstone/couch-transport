package com.bindstone.transport.domain;

import java.util.StringJoiner;

public class TransportCount {

    private String libelleMarque;

    Long count;

    public String getLibelleMarque() {
        return libelleMarque;
    }

    public void setLibelleMarque(String libelleMarque) {
        this.libelleMarque = libelleMarque;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return new StringJoiner(",", "[", "]")
                .add("libelleMarque='" + libelleMarque + "'")
                .add("count='" + count + "'")
                .toString().concat("\n");
    }
}
