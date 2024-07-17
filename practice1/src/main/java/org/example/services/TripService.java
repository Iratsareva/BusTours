package org.example.services;

import org.example.domain.Driver;
import org.example.domain.Trip;
import org.example.dto.DriverDTO;
import org.example.dto.TripDTO;

import java.util.List;

public interface TripService {
    void addTrip (TripDTO tripDTO);
    TripDTO getTripById (int id);
    List<DriverDTO> findDriverToTrip (TripDTO tripDTO);

}
