package org.example.repositories;

import org.example.domain.Tour;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository  {


    Tour create(Tour tour);
    Tour findById(Class<Tour> tourClass, int id);
    List<Tour> getAll(Class<Tour> tourClass);
    List<Tour> findTourByDestination(String destination);
    Tour findTourByTrip (int idTrip);


}
