package com.example.db_cw_backend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "quarter", schema = "s285583", catalog = "studs")
public class QuarterEntity {
    private Integer id;
    private String name;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        QuarterEntity that = (QuarterEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    private Integer x;

    @Basic
    @Column(name = "x", nullable = false)
    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    private Integer y;

    @Basic
    @Column(name = "y", nullable = false)
    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
