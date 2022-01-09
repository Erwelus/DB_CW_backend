package com.example.db_cw_backend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "quarter_quarter", schema = "s285583", catalog = "studs")
public class QuarterQuarterEntity {
    private Integer id;
    private Integer quarter1Id;
    private Integer quarter2Id;


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
        QuarterQuarterEntity that = (QuarterQuarterEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Basic
    @Column(name = "quarter1_id", nullable = false)
    public Integer getQuarter1Id() {
        return quarter1Id;
    }

    public void setQuarter1Id(Integer quarter1Id) {
        this.quarter1Id = quarter1Id;
    }

    @Basic
    @Column(name = "quarter2_id", nullable = false)
    public Integer getQuarter2Id() {
        return quarter2Id;
    }

    public void setQuarter2Id(Integer quarter2Id) {
        this.quarter2Id = quarter2Id;
    }
}
