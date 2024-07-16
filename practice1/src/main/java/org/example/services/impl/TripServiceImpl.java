package org.example.services.impl;

import org.example.domain.Trip;
import org.example.repositories.TripRepository;
import org.example.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;

public class TripServiceImpl implements TripService {
    @Autowired
    private TripRepository tripRepository;

    @Override
    public void addTrip(Trip trip) {
        tripRepository.create(trip);
    }

    @Override
    public Trip getTripById(int id) {
        return tripRepository.findById(Trip.class, id);
    }
}
