package com.test.challenge.challenge.service.dto;

public class CharacterDTO {

    private Long id;
    private String name;
    private String description;
    private String modified;
    private String thumbnail;
    private String marvelId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getMarvelId() {
        return marvelId;
    }

    public void setMarvelId(String marvelId) {
        this.marvelId = marvelId;
    }

    @Override
    public String toString() {
        return "CharacterDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", modified='" + modified + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", marvelId='" + marvelId + '\'' +
                '}';
    }
}
