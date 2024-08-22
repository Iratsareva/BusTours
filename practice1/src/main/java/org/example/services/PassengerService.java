package org.example.services;

import org.example.dto.PassengerDTO;

import java.util.List;

public interface PassengerService {
    PassengerDTO addPassenger (PassengerDTO passengerDTO);
    PassengerDTO getPassengerById(int id);
    List<PassengerDTO> findAll();

}
