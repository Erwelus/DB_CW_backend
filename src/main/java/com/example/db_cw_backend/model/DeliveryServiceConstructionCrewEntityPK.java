package com.example.db_cw_backend.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class DeliveryServiceConstructionCrewEntityPK implements Serializable {
    private Integer deliveryServiceId;
    private Integer constructionCrewId;

    @Column(name = "delivery_service_id", nullable = false)
    @Id
    public Integer getDeliveryServiceId() {
        return deliveryServiceId;
    }

    public void setDeliveryServiceId(Integer deliveryServiceId) {
        this.deliveryServiceId = deliveryServiceId;
    }

    @Column(name = "construction_crew_id", nullable = false)
    @Id
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
        DeliveryServiceConstructionCrewEntityPK that = (DeliveryServiceConstructionCrewEntityPK) o;
        return Objects.equals(deliveryServiceId, that.deliveryServiceId) && Objects.equals(constructionCrewId, that.constructionCrewId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryServiceId, constructionCrewId);
    }
}
