package org.example.repositories;

import org.example.domain.Passenger;
import org.example.domain.TourGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.reactive.TransactionalEventPublisher;

import java.util.List;

@Repository
public interface TourGroupRepository {


    Integer countPassengersUnder18InTourGroup(Integer tourGroupId);
    Integer countPassengersBefore18InTourGroup(Integer tourGroupId);


    void create (TourGroup tourGroup);
    TourGroup findById(Class<TourGroup> tourGroupClass, int id);
    TourGroup update (TourGroup tourGroup);

}
