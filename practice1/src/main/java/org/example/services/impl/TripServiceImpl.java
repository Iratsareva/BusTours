package org.example.services.impl;

import org.example.domain.Driver;
import org.example.domain.Trip;
import org.example.dto.BusDTO;
import org.example.dto.DriverDTO;
import org.example.dto.TripDTO;
import org.example.repositories.DriverRepository;
import org.example.repositories.TripRepository;
import org.example.services.TripService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private DriverRepository driverRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public void addTrip(TripDTO tripDTO) {
        Trip trip = modelMapper.map(tripDTO, Trip.class);
        tripRepository.create(trip);
    }

    @Override
    public TripDTO getTripById(int id) {
        Trip t = tripRepository.findById(Trip.class, id);
        return modelMapper.map(t, TripDTO.class);
    }

    @Override
    public List<DriverDTO> findDriverToTrip(TripDTO tripDTO) {
        Trip trip = modelMapper.map(tripDTO, Trip.class);
        return driverRepository.findDriversByTripId(trip.getId()).stream().map((driver )-> modelMapper.map(driver, DriverDTO.class)).toList();
    }
}
