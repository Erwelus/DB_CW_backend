package com.example.db_cw_backend.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "construction_crew")
public class ConstructionCrewEntity {
    private Long id;
    private Integer size;
    private ModelEntity model;
    private List<DeliveryServiceEntity> deliveryServices;

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
    @Column(name = "size", nullable = false)
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    public ModelEntity getModel() {
        return model;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }

    @ManyToMany
    @JoinTable(
            name = "delivery_construction",
            joinColumns = @JoinColumn(name = "delivery_building_id"),
            inverseJoinColumns = @JoinColumn(name = "construction_crew_id"))
    public List<DeliveryServiceEntity> getDeliveryServices() {
        return deliveryServices;
    }

    public void setDeliveryServices(List<DeliveryServiceEntity> deliveryServices) {
        this.deliveryServices = deliveryServices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConstructionCrewEntity that = (ConstructionCrewEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size);
    }
}
