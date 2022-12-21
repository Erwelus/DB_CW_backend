package com.example.db_cw_backend.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CityServiceBuildingEntityPK implements Serializable {
    private Integer serviceId;
    private Integer buildingId;

    @Column(name = "service_id", nullable = false)
    @Id
    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
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
        CityServiceBuildingEntityPK that = (CityServiceBuildingEntityPK) o;
        return Objects.equals(serviceId, that.serviceId) && Objects.equals(buildingId, that.buildingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, buildingId);
    }
}
