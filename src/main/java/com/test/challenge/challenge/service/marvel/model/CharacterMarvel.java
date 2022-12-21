package com.test.challenge.challenge.service.marvel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public ThumbnailMarvel getThumbnailMarvel() {
        return thumbnailMarvel;
    }

    public void setThumbnailMarvel(ThumbnailMarvel thumbnailMarvel) {
        this.thumbnailMarvel = thumbnailMarvel;
    }

    @Override
    public String toString() {
        return "CharacterMarvel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", modified='" + modified + '\'' +
                ", thumbnailMarvel=" + thumbnailMarvel +
                '}';
    }
}
