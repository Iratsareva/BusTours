package org.example.services;

import org.example.dto.PassengerDTO;

public interface PassengerService {
    void addPassenger (PassengerDTO passengerDTO);
    PassengerDTO getPassengerById(int id);
}
