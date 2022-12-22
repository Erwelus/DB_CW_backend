package com.example.db_cw_backend.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "building")
public class BuildingEntity {
    private Long id;
    private String type;
    private String name;
    private Integer floorNumber;
    private Integer readinessCoefficient;
    private StreetEntity street;
    private ConstructionCrewEntity constructionCrew;
    private List<CityServiceEntity> services;
    private List<MaterialInBuilding> materials;

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "name")
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

    @ManyToOne
    @JoinColumn(name = "street_id", referencedColumnName = "id")
    public StreetEntity getStreet() {
        return street;
    }
    public void setStreet(StreetEntity street) {
        this.street = street;
    }

    @ManyToOne
    @JoinColumn(name = "crew_id", referencedColumnName = "id")
    public ConstructionCrewEntity getConstructionCrew() {
        return constructionCrew;
    }
    public void setConstructionCrew(ConstructionCrewEntity constructionCrew) {
        this.constructionCrew = constructionCrew;
    }

    @ManyToMany
    @JoinTable(
            name = "building_service",
            joinColumns = @JoinColumn(name = "building_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    public List<CityServiceEntity> getServices() {
        return services;
    }

    public void setServices(List<CityServiceEntity> services) {
        this.services = services;
    }

    @OneToMany(mappedBy = "building")
    public List<MaterialInBuilding> getMaterials() {
        return materials;
    }

    public void setMaterials(List<MaterialInBuilding> materials) {
        this.materials = materials;
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
