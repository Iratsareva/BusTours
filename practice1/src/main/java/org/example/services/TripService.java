package org.example.services;

import org.example.dto.TripDTO;

import java.util.List;

public interface TripService {
    TripDTO addTrip (TripDTO tripDTO);
    TripDTO getTripById (int id);
    List<TripDTO> findAll();
//    List<DriverDTO> findDriverToTrip (TripDTO tripDTO);

}
