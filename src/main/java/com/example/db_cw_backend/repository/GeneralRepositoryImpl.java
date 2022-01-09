package com.example.db_cw_backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class GeneralRepositoryImpl implements GeneralRepository{
    EntityManager entityManager;

    @Autowired
    public GeneralRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public double countPercentageOfCity() {
        return (float) entityManager.createNativeQuery("select count_readiness_percentage_of_city()").getSingleResult();
    }
}
