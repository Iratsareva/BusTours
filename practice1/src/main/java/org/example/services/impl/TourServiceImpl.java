package org.example.services.impl;

import org.example.domain.Tour;
import org.example.repositories.TourRepository;
import org.example.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;

public class TourServiceImpl implements TourService {
    @Autowired
    private TourRepository tourRepository;

    @Override
    public void addTour(Tour tour) {
        tourRepository.create(tour);
    }

    @Override
    public Tour getTourById(int id) {
        return tourRepository.findById(Tour.class, id);
    }
}
