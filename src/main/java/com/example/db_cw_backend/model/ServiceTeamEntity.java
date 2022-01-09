package com.example.db_cw_backend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "service_team", schema = "s285583", catalog = "studs")
public class ServiceTeamEntity {
    private Integer id;
    private Float rate;
    private Integer quarterId;
    private Integer cityServiceId;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "rate", nullable = false, precision = 0)
    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceTeamEntity that = (ServiceTeamEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(rate, that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rate);
    }

    @Basic
    @Column(name = "quarter_id", nullable = false)
    public Integer getQuarterId() {
        return quarterId;
    }

    public void setQuarterId(Integer quarterId) {
        this.quarterId = quarterId;
    }

    @Basic
    @Column(name = "service_id", nullable = false)
    public Integer getCityServiceId() {
        return cityServiceId;
    }

    public void setCityServiceId(Integer cityServiceId) {
        this.cityServiceId = cityServiceId;
    }
}
