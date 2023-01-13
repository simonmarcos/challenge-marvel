package com.test.challenge.service.marvel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericMarvelResponse {

    @JsonProperty("data")
    private DataMarvelResponse dataMarvelResponse;

    public DataMarvelResponse getDataMarvelResponse() {
        return dataMarvelResponse;
    }

    public void setDataMarvelResponse(DataMarvelResponse dataMarvelResponse) {
        this.dataMarvelResponse = dataMarvelResponse;
    }

    @Override
    public String toString() {
        return "GenericMarvelResponse{" +
                "dataMarvelResponse=" + dataMarvelResponse +
                '}';
    }
}
