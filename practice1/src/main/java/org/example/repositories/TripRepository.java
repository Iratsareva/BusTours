package org.example.repositories;

import org.example.domain.Driver;
import org.example.domain.Tour;
import org.example.domain.Trip;
import org.example.domain.TripStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TripRepository  {

    void create(Trip trip);
    Trip findById (Class<Trip> tripClass, int id);
    Trip update (Trip trip);


}
