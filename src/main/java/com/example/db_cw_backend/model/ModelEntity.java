package com.example.db_cw_backend.model;

import javax.persistence.*;

@Entity
@Table(name = "model")
public class ModelEntity {
    private Long id;
    private String name;

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
