package ru.ervelus.rest.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "service_team")
public class ServiceTeamEntity {
    private Long id;
    private Float rate;
    private QuarterEntity quarter;
    private CityServiceEntity cityService;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "rate")
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

    @ManyToOne
    @JoinColumn(name = "quarter_id", referencedColumnName = "id")
    public QuarterEntity getQuarter() {
        return quarter;
    }
    public void setQuarter(QuarterEntity quarter) {
        this.quarter = quarter;
    }

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    public CityServiceEntity getCityService() {
        return cityService;
    }
    public void setCityService(CityServiceEntity cityService) {
        this.cityService = cityService;
    }
}
