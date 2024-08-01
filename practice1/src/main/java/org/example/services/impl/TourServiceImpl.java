package org.example.services.impl;

import org.example.domain.Passenger;
import org.example.domain.Tour;
import org.example.domain.TourGroup;
import org.example.dto.PassengerDTO;
import org.example.dto.TourDTO;
import org.example.dto.TourGroupDTO;
import org.example.repositories.TourGroupRepository;
import org.example.repositories.TourRepository;
import org.example.services.TourService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TourServiceImpl implements TourService {
    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private TourGroupRepository tourGroupRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public void addTour(TourDTO tourDTO) {
        Tour tour = modelMapper.map(tourDTO, Tour.class );
        tourRepository.create(tour);
    }


    @Override
    public TourDTO getTourById(int id) {
        Tour t = tourRepository.findById(Tour.class, id);
        return modelMapper.map(t, TourDTO.class);
    }


    @Override
    public List<TourDTO> getRecommendationsTour(PassengerDTO passengerDTO) {
        Passenger passenger = modelMapper.map(passengerDTO, Passenger.class);
        return tourRepository.findToursByPassengerId(passenger.getId()).stream().map((tour) -> modelMapper.map(tour,TourDTO.class)).toList();
    }

    @Override
    public List<TourDTO> getTourForTourGroup(TourGroupDTO tourGroupDTO) {
        TourGroup tourGroup = modelMapper.map(tourGroupDTO, TourGroup.class);
       Integer countC = tourGroupRepository.countPassengersBefore18InTourGroup(tourGroup.getId());
       Integer countP = tourGroupRepository.countPassengersUnder18InTourGroup(tourGroup.getId());

        return tourRepository.findToursByTourGroup(countC, countP).stream().map((tour) -> modelMapper.map(tour, TourDTO.class)).toList();
    }
}
