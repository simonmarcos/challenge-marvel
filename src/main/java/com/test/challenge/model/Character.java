package com.test.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "character")
public class Character extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "modified")
    private String modified;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "marvelId")
    private String marvelId;

    @ManyToOne
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = {"password"}, allowSetters = true)
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMarvelId() {
        return marvelId;
    }

    public void setMarvelId(String marvelId) {
        this.marvelId = marvelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return id.equals(character.id) || marvelId.equals(character.marvelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, marvelId);
    }

    @Override
    public String toString() {
        return "Character{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", modified='" + modified + '\'' + ", thumbnail='" + thumbnail + '\'' + ", marvelId='" + marvelId + '\'' + ", user=" + user + '}';
    }
}
