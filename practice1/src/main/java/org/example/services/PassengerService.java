package org.example.services;

import org.example.domain.Passenger;

public interface PassengerService {
    void addPassenger (Passenger passenger);
    Passenger getPassengerById(int id);
}
