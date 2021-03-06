package com.example.db_cw_backend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "building", schema = "s285583", catalog = "studs")
public class BuildingEntity {
    private Integer id;
    private String type;
    private String name;
    private Integer floorNumber;
    private Integer readinessCoefficient;
    private Integer streetId;
    private Integer committeeId;
    private Integer crewId;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = false, length = -1)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "floor_number", nullable = false)
    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Basic
    @Column(name = "readiness_coefficient", nullable = false)
    public Integer getReadinessCoefficient() {
        return readinessCoefficient;
    }

    public void setReadinessCoefficient(Integer readinessCoefficient) {
        this.readinessCoefficient = readinessCoefficient;
    }

    @Basic
    @Column(name = "street_id", nullable = false)
    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    @Basic
    @Column(name = "committee_id", nullable = false)
    public Integer getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(Integer committeeId) {
        this.committeeId = committeeId;
    }

    @Basic
    @Column(name = "crew_id", nullable = false)
    public Integer getCrewId() {
        return crewId;
    }

    public void setCrewId(Integer crewId) {
        this.crewId = crewId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuildingEntity that = (BuildingEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(type, that.type) && Objects.equals(name, that.name) && Objects.equals(floorNumber, that.floorNumber) && Objects.equals(readinessCoefficient, that.readinessCoefficient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, floorNumber, readinessCoefficient);
    }
}
