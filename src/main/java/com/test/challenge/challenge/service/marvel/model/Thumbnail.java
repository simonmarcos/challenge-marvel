package com.test.challenge.challenge.service.marvel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Thumbnail {

    @JsonProperty("path")
    private String path;

    @JsonProperty("extension")
    private String extension;
}
