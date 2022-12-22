package com.example.db_cw_backend.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "street")
public class StreetEntity {
    private Long id;
    private String name;
    private QuarterEntity quarter;
    private List<RouteEntity> routes;

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
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreetEntity that = (StreetEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @ManyToOne
    @JoinColumn(name = "quarter_id", referencedColumnName = "id")
    public QuarterEntity getQuarter() {
        return quarter;
    }

    public void setQuarter(QuarterEntity quarterByQuarterId) {
        this.quarter = quarterByQuarterId;
    }

    @ManyToMany(mappedBy = "streets")
    public List<RouteEntity> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RouteEntity> routes) {
        this.routes = routes;
    }
}
