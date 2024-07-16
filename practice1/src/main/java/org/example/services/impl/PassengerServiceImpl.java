package org.example.services.impl;

import org.example.domain.Passenger;
import org.example.repositories.PassengerRepository;
import org.example.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;

public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public void addPassenger(Passenger passenger) {
        passengerRepository.create(passenger);
    }

    @Override
    public Passenger getPassengerById(int id) {
        return passengerRepository.findById(Passenger.class, id);
    }
}
