package com.example.db_cw_backend.model;

import javax.persistence.*;

@Entity
@Table(name = "material_building")
public class MaterialInBuilding {
    private MaterialBuildingPK id;
    private MaterialEntity material;
    private BuildingEntity building;
    private Long quantity;

    @EmbeddedId
    public MaterialBuildingPK getId() {
        return id;
    }

    public void setId(MaterialBuildingPK id) {
        this.id = id;
    }

    @ManyToOne
    @MapsId("materialId")
    @JoinColumn(name = "material_id")
    public MaterialEntity getMaterial() {
        return material;
    }

    public void setMaterial(MaterialEntity material) {
        this.material = material;
    }

    @ManyToOne
    @MapsId("buildingId")
    @JoinColumn(name = "building_id")
    public BuildingEntity getBuilding() {
        return building;
    }

    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }

    @Column(name = "quantity")
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
