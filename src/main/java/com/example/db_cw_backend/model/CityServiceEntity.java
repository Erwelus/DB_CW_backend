package com.example.db_cw_backend.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "city_service")
public class CityServiceEntity {
    private Long id;
    private String type;
    private Float price;
    private List<BuildingEntity> buildings;
    private ModelEntity model;

    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @NotNull
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @NotNull
    @Column(name = "price")
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @ManyToMany(mappedBy = "services")
    public List<BuildingEntity> getBuildings() {
        return buildings;
    }
    public void setBuildings(List<BuildingEntity> buildings) {
        this.buildings = buildings;
    }

    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    public ModelEntity getModel() {
        return model;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityServiceEntity that = (CityServiceEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(type, that.type) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, price);
    }
}
