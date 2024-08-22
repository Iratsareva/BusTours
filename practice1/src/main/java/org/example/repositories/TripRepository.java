package org.example.repositories;

import org.example.domain.Trip;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TripRepository  {

    Trip create(Trip trip);
    Trip findById (Class<Trip> tripClass, int id);
    List<Trip> getAll(Class<Trip> tripClass);

    Trip findTripByTicket (int idTicket);
    List<Trip> findTripByTour (int idTour);

}
