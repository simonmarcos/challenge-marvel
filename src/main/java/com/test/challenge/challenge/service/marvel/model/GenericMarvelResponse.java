package com.test.challenge.challenge.service.marvel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GenericMarvelResponse {

    @JsonProperty("data")
    private DataMarvelResponse dataMarvelResponse;
}
