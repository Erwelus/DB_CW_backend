package com.example.db_cw_backend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "material_building", schema = "s285583", catalog = "studs")
@IdClass(MaterialBuildingEntityPK.class)
public class MaterialBuildingEntity {
    private Integer materialId;
    private Integer buildingId;
    private Integer quantity;
    private MaterialEntity materialByMaterialId;
    private BuildingEntity buildingByBuildingId;

    @Id
    @Column(name = "material_id", nullable = false)
    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    @Id
    @Column(name = "building_id", nullable = false)
    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialBuildingEntity that = (MaterialBuildingEntity) o;
        return Objects.equals(materialId, that.materialId) && Objects.equals(buildingId, that.buildingId) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialId, buildingId, quantity);
    }

    @ManyToOne
    @JoinColumn(name = "material_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public MaterialEntity getMaterialByMaterialId() {
        return materialByMaterialId;
    }

    public void setMaterialByMaterialId(MaterialEntity materialByMaterialId) {
        this.materialByMaterialId = materialByMaterialId;
    }

    @ManyToOne
    @JoinColumn(name = "building_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public BuildingEntity getBuildingByBuildingId() {
        return buildingByBuildingId;
    }

    public void setBuildingByBuildingId(BuildingEntity buildingByBuildingId) {
        this.buildingByBuildingId = buildingByBuildingId;
    }
}
