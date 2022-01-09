package com.example.db_cw_backend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "street_street", schema = "s285583", catalog = "studs")
public class StreetStreetEntity {
    private Integer id;
    private Integer street1Id;
    private Integer street2Id;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreetStreetEntity that = (StreetStreetEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Basic
    @Column(name = "street1_id", nullable = false)
    public Integer getStreet1Id() {
        return street1Id;
    }

    public void setStreet1Id(Integer street1Id) {
        this.street1Id = street1Id;
    }

    @Basic
    @Column(name = "street2_id", nullable = false)
    public Integer getStreet2Id() {
        return street2Id;
    }

    public void setStreet2Id(Integer street2Id) {
        this.street2Id = street2Id;
    }
}
