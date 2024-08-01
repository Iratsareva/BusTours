package org.example.repositories;

import org.example.domain.Tour;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository  {

    List<Tour> findToursByPassengerId(Integer passengerId);
    List<Tour> findToursByTourGroup(Integer children, Integer notChildren);

    void create(Tour tour);
    Tour findById(Class<Tour> tourClass, int id);
    Tour update (Tour tour);

}
