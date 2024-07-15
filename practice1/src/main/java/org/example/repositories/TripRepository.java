package org.example.repositories;

import org.example.entities.Driver;
import org.example.entities.Tour;
import org.example.entities.Trip;
import org.example.entities.TripStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {

    //Найти Тур по id Рейса
    @Query(value = "select t from Tour t" +
            "join t.trips tr where tr.id = :id")
    List<Tour> findTourByTripIn(@Param(value = "id") Integer id);



    //Найти Водителя по id Рейса
    @Query(value = "select d from Driver" +
            "join d.trips tr where tr.id = :id")
    List<Driver> findDriverByTripIn(@Param(value = "id") Integer id);



    // Найти рейс по id  тура и дате отправления
    @Query(value = "select t from Tour t" +
            "join t.trips tr where tr.id = :id " +
            "and t.startDate = :startDate")
    List<Trip> findByTourAndStartDate(@Param(value = "id")Integer id,
                                      @Param(value = "startDate")LocalDate startDate );



    //Найти водителей которые не заняты на нужную дату
    @Query(value = "select d from Driver" +
            "join d.trips tr where tr.tripStatus <> 'ON_WAY'")
    List<Driver> findByTripNot(@Param(value = "tripStatus") TripStatus tripStatus);


}
