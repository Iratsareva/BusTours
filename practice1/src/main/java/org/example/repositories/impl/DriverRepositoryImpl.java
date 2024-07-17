package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.domain.Driver;
import org.example.repositories.AbstractRepository;
import org.example.repositories.DriverRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DriverRepositoryImpl extends AbstractRepository<Driver> implements DriverRepository {
    @PersistenceContext
    private EntityManager entityManager;




    //Найти водителя который свободен для рейса c конкретным id
    @Override
    public List<Driver> findDriversByTripId(Integer tripId) {
        String subQuery = "select t.startDate from Trip t where t.id = :tripId";
        TypedQuery<Driver> query = entityManager.createQuery(
                        "select d from Driver d " +
                                "where d.id not in " +
                                "(select t.id_driver from Trip t " +
                                "join t.driver d " +
                                "where t.endDate >= (" +
                                subQuery +
                                ") and t.startDate <= (" +
                                subQuery + "))", Driver.class);
        return query.setParameter("tripId", tripId).getResultList();
    }




}
