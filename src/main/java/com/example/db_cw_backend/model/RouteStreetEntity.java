package com.example.db_cw_backend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "route_street", schema = "s285583", catalog = "studs")
@IdClass(RouteStreetEntityPK.class)
public class RouteStreetEntity {
    private Integer routeId;
    private Integer streetId;
    private RouteEntity routeByRouteId;

    @Id
    @Column(name = "route_id", nullable = false)
    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    @Id
    @Column(name = "street_id", nullable = false)
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
        RouteStreetEntity that = (RouteStreetEntity) o;
        return Objects.equals(routeId, that.routeId) && Objects.equals(streetId, that.streetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, streetId);
    }

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public RouteEntity getRouteByRouteId() {
        return routeByRouteId;
    }

    public void setRouteByRouteId(RouteEntity routeByRouteId) {
        this.routeByRouteId = routeByRouteId;
    }
}
