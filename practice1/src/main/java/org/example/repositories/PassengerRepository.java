package org.example.repositories;

import org.example.entities.Passenger;
import org.example.entities.TourGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

    // Найти Тур группы в которых есть конкретный пассажир по id
    @Query(value = "select tg from TourGroup tg" +
            "join tg.passenger p where p.id = :id ")
    List<TourGroup> findByPassengerIn(@Param(value = "id") Integer id);


}
