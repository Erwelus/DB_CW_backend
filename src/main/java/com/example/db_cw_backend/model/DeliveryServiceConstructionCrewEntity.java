package com.example.db_cw_backend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "delivery_service_construction_crew")
@IdClass(DeliveryServiceConstructionCrewEntityPK.class)
public class DeliveryServiceConstructionCrewEntity {
    private Integer deliveryServiceId;
    private Integer constructionCrewId;
    private DeliveryServiceEntity deliveryServiceByDeliveryServiceId;
    private ConstructionCrewEntity constructionCrewByConstructionCrewId;

    @Id
    @Column(name = "delivery_service_id", nullable = false)
    public Integer getDeliveryServiceId() {
        return deliveryServiceId;
    }

    public void setDeliveryServiceId(Integer deliveryServiceId) {
        this.deliveryServiceId = deliveryServiceId;
    }

    @Id
    @Column(name = "construction_crew_id", nullable = false)
    public Integer getConstructionCrewId() {
        return constructionCrewId;
    }

    public void setConstructionCrewId(Integer constructionCrewId) {
        this.constructionCrewId = constructionCrewId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryServiceConstructionCrewEntity that = (DeliveryServiceConstructionCrewEntity) o;
        return Objects.equals(deliveryServiceId, that.deliveryServiceId) && Objects.equals(constructionCrewId, that.constructionCrewId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryServiceId, constructionCrewId);
    }

    @ManyToOne
    @JoinColumn(name = "delivery_service_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public DeliveryServiceEntity getDeliveryServiceByDeliveryServiceId() {
        return deliveryServiceByDeliveryServiceId;
    }

    public void setDeliveryServiceByDeliveryServiceId(DeliveryServiceEntity deliveryServiceByDeliveryServiceId) {
        this.deliveryServiceByDeliveryServiceId = deliveryServiceByDeliveryServiceId;
    }

    @ManyToOne
    @JoinColumn(name = "construction_crew_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public ConstructionCrewEntity getConstructionCrewByConstructionCrewId() {
        return constructionCrewByConstructionCrewId;
    }

    public void setConstructionCrewByConstructionCrewId(ConstructionCrewEntity constructionCrewByConstructionCrewId) {
        this.constructionCrewByConstructionCrewId = constructionCrewByConstructionCrewId;
    }
}
