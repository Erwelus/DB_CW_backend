package ru.ervelus.rest.model;

import javax.persistence.*;

@Entity
@Table(name = "material_building")
public class MaterialInBuilding {
    private Long id;
    private MaterialEntity material;
    private BuildingEntity building;
    private Long quantity;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "material_id")
    public MaterialEntity getMaterial() {
        return material;
    }

    public void setMaterial(MaterialEntity material) {
        this.material = material;
    }

    @ManyToOne
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
