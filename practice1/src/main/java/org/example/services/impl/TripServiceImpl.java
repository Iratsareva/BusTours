package org.example.services.impl;

import org.example.domain.Trip;
import org.example.domain.TripStatus;
import org.example.dto.TripDTO;
import org.example.exception.PasNotFoundException;
import org.example.repositories.TripRepository;
import org.example.services.TripService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripRepository tripRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Transactional
    @Override
    public TripDTO addTrip(TripDTO tripDTO) {
        Trip trip = modelMapper.map(tripDTO, Trip.class);
        if (trip.getTour() == null) {
            throw new PasNotFoundException("Такого тура не существует");
        }


        if (trip.getStartDate().isAfter(LocalDate.now())) {
            trip.setTripStatus(TripStatus.AWAITING);
        } else if (trip.getEndDate().isBefore(LocalDate.now())) {
            trip.setTripStatus(TripStatus.COMPLETED);
        }else trip.setTripStatus(TripStatus.ON_WAY);



        return modelMapper.map(tripRepository.create(trip), TripDTO.class);
    }

    @Override
    public TripDTO getTripById(int id) {
        Trip t = tripRepository.findById(Trip.class, id);
        return modelMapper.map(t, TripDTO.class);
    }



    @Override
    @Transactional
    public List<TripDTO> findAll() {

        for (Trip trip : tripRepository.getAll(Trip.class)) {
            if (trip.getStartDate().isAfter(LocalDate.now())) {
                trip.setTripStatus(TripStatus.AWAITING);
            } else if (trip.getEndDate().isBefore(LocalDate.now())) {
                trip.setTripStatus(TripStatus.COMPLETED);
            } else trip.setTripStatus(TripStatus.ON_WAY);
        }

        return tripRepository.getAll(Trip.class).stream().map(trip ->
                modelMapper.map(trip, TripDTO.class)).toList();
    }






}
