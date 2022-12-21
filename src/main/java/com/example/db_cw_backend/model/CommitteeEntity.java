package com.example.db_cw_backend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "committee")
public class CommitteeEntity {
    private Integer id;
    private Integer strictness;

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "strictness", nullable = false)
    public Integer getStrictness() {
        return strictness;
    }

    public void setStrictness(Integer strictness) {
        this.strictness = strictness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommitteeEntity that = (CommitteeEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(strictness, that.strictness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, strictness);
    }
}
