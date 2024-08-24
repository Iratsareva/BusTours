package org.example.repositories.impl;

import jakarta.persistence.TypedQuery;
import org.example.domain.Driver;
import org.example.repositories.AbstractRepository;
import org.example.repositories.DriverRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DriverRepositoryImpl extends AbstractRepository<Driver> implements DriverRepository {
    //Найти водителя который свободен для рейса c конкретным id
    public Driver findDriverByTrip(Integer tripId) {
        TypedQuery<Driver> query = entityManager.createQuery(
                "select d from Driver d " +
                        "join d.trips tr " +
                        "where tr.id = :id", Driver.class);
        return query.setParameter("id", tripId).getSingleResult();
    }
}
