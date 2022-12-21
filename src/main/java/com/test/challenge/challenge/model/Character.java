package com.test.challenge.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "character")
@Data
public class Character extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "modified")
    private String modified;

    @Column(name = "thumbnail")
    private String thumbnail;

    @ManyToOne
    @JsonIgnoreProperties(value = {"password"}, allowSetters = true)
    private User user;
}
