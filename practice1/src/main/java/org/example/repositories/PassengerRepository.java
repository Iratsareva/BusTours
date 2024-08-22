package org.example.repositories;

import org.example.domain.Passenger;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository {
    Passenger create(Passenger passenger);
    Passenger findById(Class<Passenger> passengerClass, int id);
    List<Passenger> getAll(Class<Passenger> passengerClass);
}
