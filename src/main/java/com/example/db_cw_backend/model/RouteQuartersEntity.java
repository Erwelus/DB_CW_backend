package com.example.db_cw_backend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "route_quarters")
@IdClass(RouteQuartersEntityPK.class)
public class RouteQuartersEntity {
    private Integer routeId;
    private Integer quarterFrom;
    private Integer quarterTo;
    private RouteEntity routeByRouteId;
    private QuarterEntity quarterByQuarterFrom;
    private QuarterEntity quarterByQuarterTo;

    @Id
    @Column(name = "route_id", nullable = false)
    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    @Id
    @Column(name = "quarter_from", nullable = false)
    public Integer getQuarterFrom() {
        return quarterFrom;
    }

    public void setQuarterFrom(Integer quarterFrom) {
        this.quarterFrom = quarterFrom;
    }

    @Id
    @Column(name = "quarter_to", nullable = false)
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
        RouteQuartersEntity that = (RouteQuartersEntity) o;
        return Objects.equals(routeId, that.routeId) && Objects.equals(quarterFrom, that.quarterFrom) && Objects.equals(quarterTo, that.quarterTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, quarterFrom, quarterTo);
    }

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public RouteEntity getRouteByRouteId() {
        return routeByRouteId;
    }

    public void setRouteByRouteId(RouteEntity routeByRouteId) {
        this.routeByRouteId = routeByRouteId;
    }

    @ManyToOne
    @JoinColumn(name = "quarter_from", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public QuarterEntity getQuarterByQuarterFrom() {
        return quarterByQuarterFrom;
    }

    public void setQuarterByQuarterFrom(QuarterEntity quarterByQuarterFrom) {
        this.quarterByQuarterFrom = quarterByQuarterFrom;
    }

    @ManyToOne
    @JoinColumn(name = "quarter_to", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public QuarterEntity getQuarterByQuarterTo() {
        return quarterByQuarterTo;
    }

    public void setQuarterByQuarterTo(QuarterEntity quarterByQuarterTo) {
        this.quarterByQuarterTo = quarterByQuarterTo;
    }
}
