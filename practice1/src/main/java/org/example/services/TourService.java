package org.example.services;

import org.example.dto.PassengerDTO;
import org.example.dto.TourDTO;
import org.example.dto.TourGroupDTO;

import java.util.List;

public interface TourService {
    void addTour (TourDTO tourDTO);
    TourDTO getTourById (int id);

    List<TourDTO> getRecommendationsTour (PassengerDTO passengerDTO);

    List<TourDTO> getTourForTourGroup (TourGroupDTO tourGroupDTO);
}
