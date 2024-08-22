package org.example.services.impl;

import org.example.domain.Passenger;
import org.example.dto.PassengerDTO;
import org.example.repositories.PassengerRepository;
import org.example.services.PassengerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Transactional
    @Override
    public PassengerDTO addPassenger(PassengerDTO passengerDTO) {
        Passenger passenger = modelMapper.map(passengerDTO,Passenger.class);
        return modelMapper.map(passengerRepository.create(passenger),PassengerDTO.class) ;
    }

    @Override
    public PassengerDTO getPassengerById(int id) {
        Passenger p = passengerRepository.findById(Passenger.class, id);
        return modelMapper.map(p,PassengerDTO.class);
    }

    @Override
    @Transactional
    public List<PassengerDTO> findAll() {
        return passengerRepository.getAll(Passenger.class).stream().map(passenger ->
                modelMapper.map(passenger, PassengerDTO.class)).toList();
    }
}
