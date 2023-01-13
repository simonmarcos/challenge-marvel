package com.test.challenge.service.dto;

public class CharacterMarvelDTO {

    private String name;
    private String description;
    private String modified;
    private String thumbnail;
    private String marvelId;

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
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", modified='" + modified + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", marvelId='" + marvelId + '\'' +
                '}';
    }
}
