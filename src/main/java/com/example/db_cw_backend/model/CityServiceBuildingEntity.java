package com.example.db_cw_backend.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "city_service_building", schema = "s285583", catalog = "studs")
@IdClass(CityServiceBuildingEntityPK.class)
public class CityServiceBuildingEntity {
    private Integer serviceId;
    private Integer buildingId;
    private CityServiceEntity cityServiceByServiceId;
    private BuildingEntity buildingByBuildingId;

    @Id
    @Column(name = "service_id", nullable = false)
    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    @Id
    @Column(name = "building_id", nullable = false)
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
        CityServiceBuildingEntity that = (CityServiceBuildingEntity) o;
        return Objects.equals(serviceId, that.serviceId) && Objects.equals(buildingId, that.buildingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, buildingId);
    }

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public CityServiceEntity getCityServiceByServiceId() {
        return cityServiceByServiceId;
    }

    public void setCityServiceByServiceId(CityServiceEntity cityServiceByServiceId) {
        this.cityServiceByServiceId = cityServiceByServiceId;
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
