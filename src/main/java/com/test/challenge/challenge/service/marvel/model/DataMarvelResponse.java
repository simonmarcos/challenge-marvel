package com.test.challenge.challenge.service.marvel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DataMarvelResponse {

    @JsonProperty("offset")
    private Integer offset;

    @JsonProperty("limit")
    private Integer limit;

    @JsonProperty("total")
    private Integer total;

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("results")
    private List<CharacterMarvel> results;
}
