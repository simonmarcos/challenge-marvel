package com.test.challenge.service.marvel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ThumbnailMarvel {

    @JsonProperty("path")
    private String path;

    @JsonProperty("extension")
    private String extension;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "ThumbnailDTO{" +
                "path='" + path + '\'' +
                ", extension='" + extension + '\'' +
                '}';
    }
}
