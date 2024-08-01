package org.example.repositories;


import org.example.domain.TourGroup;
import org.springframework.stereotype.Repository;

@Repository
public interface TourGroupRepository {

    void create (TourGroup tourGroup);
    TourGroup findById(Class<TourGroup> tourGroupClass, int id);

    TourGroup update (TourGroup tourGroup);

    Integer countPassengersUnder18InTourGroup(Integer tourGroupId);
    Integer countPassengersBefore18InTourGroup(Integer tourGroupId);




}
