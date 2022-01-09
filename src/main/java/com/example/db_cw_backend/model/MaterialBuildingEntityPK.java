package com.example.db_cw_backend.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MaterialBuildingEntityPK implements Serializable {
    private Integer materialId;
    private Integer buildingId;

    @Column(name = "material_id", nullable = false)
    @Id
    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    @Column(name = "building_id", nullable = false)
    @Id
    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialBuildingEntityPK that = (MaterialBuildingEntityPK) o;
        return Objects.equals(materialId, that.materialId) && Objects.equals(buildingId, that.buildingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialId, buildingId);
    }
}
