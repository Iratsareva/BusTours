package org.example.repositories;

import org.example.domain.Passenger;
import org.example.domain.TourGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository {
    void create(Passenger passenger);
    Passenger findById(Class<Passenger> passengerClass, int id);
    Passenger update (Passenger passenger);
}
