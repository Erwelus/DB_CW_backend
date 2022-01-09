package com.example.db_cw_backend.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RouteQuartersEntityPK implements Serializable {
    private Integer routeId;
    private Integer quarterFrom;
    private Integer quarterTo;

    @Column(name = "route_id", nullable = false)
    @Id
    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    @Column(name = "quarter_from", nullable = false)
    @Id
    public Integer getQuarterFrom() {
        return quarterFrom;
    }

    public void setQuarterFrom(Integer quarterFrom) {
        this.quarterFrom = quarterFrom;
    }

    @Column(name = "quarter_to", nullable = false)
    @Id
    public Integer getQuarterTo() {
        return quarterTo;
    }

    public void setQuarterTo(Integer quarterTo) {
        this.quarterTo = quarterTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteQuartersEntityPK that = (RouteQuartersEntityPK) o;
        return Objects.equals(routeId, that.routeId) && Objects.equals(quarterFrom, that.quarterFrom) && Objects.equals(quarterTo, that.quarterTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, quarterFrom, quarterTo);
    }
}
