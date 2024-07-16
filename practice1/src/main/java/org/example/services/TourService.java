package org.example.services;

import org.example.domain.Tour;
import org.example.domain.TourGroup;

public interface TourService {
    void addTour (Tour tour);
    Tour getTourById (int id);
}
