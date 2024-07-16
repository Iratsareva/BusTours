package org.example.services;

import org.example.domain.Trip;

public interface TripService {
    void addTrip (Trip trip);
    Trip getTripById (int id);
}
