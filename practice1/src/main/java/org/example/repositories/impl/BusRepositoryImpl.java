package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.domain.Bus;
import org.example.repositories.AbstractRepository;
import org.example.repositories.BusRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BusRepositoryImpl extends AbstractRepository<Bus> implements BusRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Bus findBusByTrip (Integer idTrip){
        TypedQuery<Bus> query = entityManager.createQuery(
                "select b from Bus b " +
                        "join b.trips t " +
                        "where t.id = :id", Bus.class);
        return query.setParameter("id", idTrip).getSingleResult();
    }

}
