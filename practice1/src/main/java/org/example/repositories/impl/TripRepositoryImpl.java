package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.domain.Trip;
import org.example.repositories.AbstractRepository;
import org.example.repositories.TripRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TripRepositoryImpl extends AbstractRepository<Trip> implements TripRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Trip findTripByTicket (int idTicket){
        TypedQuery<Trip> query = entityManager.createQuery(
                "select tr from Trip tr " +
                        "join tr.tickets ti " +
                        "where ti.id = :id", Trip.class);
        return query.setParameter("id", idTicket).getSingleResult();
    }


    @Override
    public List<Trip> findTripByTour (int idTour){
        TypedQuery<Trip> query = entityManager.createQuery(
                "select tr from Trip tr " +
                        "join tr.tour tour " +
                        "where tour.id = :id" , Trip.class);
        return query.setParameter("id", idTour).getResultList();
    }

}
