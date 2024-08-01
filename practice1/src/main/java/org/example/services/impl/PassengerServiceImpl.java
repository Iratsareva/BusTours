package org.example.services.impl;

import org.example.domain.Passenger;
import org.example.dto.PassengerDTO;
import org.example.repositories.PassengerRepository;
import org.example.services.PassengerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public void addPassenger(PassengerDTO passengerDTO) {
        Passenger passenger = modelMapper.map(passengerDTO,Passenger.class);
        passengerRepository.create(passenger);
    }

    @Override
    public PassengerDTO getPassengerById(int id) {
        Passenger p = passengerRepository.findById(Passenger.class, id);
        return modelMapper.map(p,PassengerDTO.class);
    }
}
