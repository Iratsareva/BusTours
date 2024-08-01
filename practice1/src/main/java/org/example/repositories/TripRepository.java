package org.example.repositories;

import org.example.domain.Trip;
import org.springframework.stereotype.Repository;


@Repository
public interface TripRepository  {

    void create(Trip trip);
    Trip findById (Class<Trip> tripClass, int id);
    Trip update (Trip trip);

}
