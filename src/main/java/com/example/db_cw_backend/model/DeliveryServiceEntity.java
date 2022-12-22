package com.example.db_cw_backend.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "delivery_service")
public class DeliveryServiceEntity {
    private Long id;
    private String name;
    private Float rate;
    private MaterialEntity material;
    private List<ConstructionCrewEntity> crews;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @NotNull
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @NotNull
    @Column(name = "rate")
    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    @ManyToOne
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    public MaterialEntity getMaterial() {
        return material;
    }
    public void setMaterial(MaterialEntity material) {
        this.material = material;
    }

    @ManyToMany(mappedBy = "deliveryServices")
    public List<ConstructionCrewEntity> getCrews() {
        return crews;
    }

    public void setCrews(List<ConstructionCrewEntity> crews) {
        this.crews = crews;
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
