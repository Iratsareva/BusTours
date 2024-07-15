package org.example.repositories;

import org.example.entities.Passenger;
import org.example.entities.TourGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourGroupRepository extends JpaRepository<TourGroup, Integer> {

    //Найти пассажиров тур группы
    @Query(value = "select p Passenger p" +
            "jon p.tourGroups tg where tg.id = :id")
    List<Passenger> findByTourGroupIn(@Param(value = "id") Integer id);
}
