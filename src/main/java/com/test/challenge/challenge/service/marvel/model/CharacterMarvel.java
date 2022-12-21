package com.test.challenge.challenge.service.marvel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CharacterMarvel {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("modified")
    private String modified;

    @JsonProperty("thumbnail")
    private ThumbnailMarvel thumbnailMarvel;
}
