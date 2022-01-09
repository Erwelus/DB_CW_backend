package com.example.db_cw_backend.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RouteStreetEntityPK implements Serializable {
    private Integer routeId;
    private Integer streetId;

    @Column(name = "route_id", nullable = false)
    @Id
    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    @Column(name = "street_id", nullable = false)
    @Id
    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteStreetEntityPK that = (RouteStreetEntityPK) o;
        return Objects.equals(routeId, that.routeId) && Objects.equals(streetId, that.streetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, streetId);
    }
}
