package org.example.services;

import org.example.dto.TourDTO;
import org.example.dto.TripDTO;

import java.util.List;

public interface TourService {
    TourDTO addTour (TourDTO tourDTO);
    TourDTO getTourById (int id);
    List<TourDTO> findAll();
    List<TripDTO> findTourByParameters (String destination, Integer numberPassengers);

//    List<TourDTO> getRecommendationsTour (PassengerDTO passengerDTO);

//    List<TourDTO> getTourForTourGroup (TourGroupDTO tourGroupDTO);
}
