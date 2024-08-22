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





//        String startTrip = "select t.startDate from Trip t where t.id = :tripId";
//
//        TypedQuery<Driver> query = entityManager.createQuery(
//                        "select d from Driver d " +
//                                "where d.id not in " +
//                                "(select t.driver.id from Trip t " +
//                                "join t.driver d " +
//                                "where " +
//                                "t.endDate >= (" + startTrip + ") " +
//                                "and " +
//                                "t.startDate <= (" + startTrip + "))", Driver.class);
        return query.setParameter("id", tripId).getSingleResult();
    }





}
