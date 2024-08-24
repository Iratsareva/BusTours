package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.domain.Tour;
import org.example.repositories.AbstractRepository;
import org.example.repositories.TourRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TourRepositoryImpl extends AbstractRepository<Tour> implements TourRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Tour> findTourByDestination(String destination){
        TypedQuery<Tour> query = entityManager.createQuery(
                "select t from Tour t " +
                        "where t.destination = :destination", Tour.class);
        return query.setParameter("destination", destination).getResultList();
    }


    @Override
    public Tour findTourByTrip (int idTrip){
        TypedQuery<Tour> query = entityManager.createQuery(
                "select t from Tour t " +
                        "join t.trips tr " +
                        "where tr.id = :id", Tour.class);
        return query.setParameter("id", idTrip).getSingleResult();
    }


}
