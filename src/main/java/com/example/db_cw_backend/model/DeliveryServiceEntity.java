package com.example.db_cw_backend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "delivery_service")
public class DeliveryServiceEntity {
    private Integer id;
    private String name;
    private Float rate;
    private Integer materialId;
    private MaterialEntity materialByMaterialId;

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
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "rate", nullable = false, precision = 0)
    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    @Basic
    @Column(name = "material_id", nullable = false)
    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    @ManyToOne
    @JoinColumn(name = "material_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public MaterialEntity getMaterialByMaterialId() {
        return materialByMaterialId;
    }
    public void setMaterialByMaterialId(MaterialEntity materialByMaterialId) {
        this.materialByMaterialId = materialByMaterialId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryServiceEntity that = (DeliveryServiceEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(rate, that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rate);
    }
}
