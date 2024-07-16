package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.domain.Passenger;
import org.example.domain.Tour;
import org.example.domain.TourGroup;
import org.example.repositories.AbstractRepository;
import org.example.repositories.TourGroupRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class TourGroupRepositoryImpl extends AbstractRepository<TourGroup> implements TourGroupRepository {
    @PersistenceContext
    private EntityManager entityManager;

    // Анализ тур группы для подбора туров
    //Дети
    @Override
    public Integer countPassengersUnder18InTourGroup(Integer tourGroupId) {

        String subQuery = "select (extract(year from current_date) - extract(year from p.birthday)) as years " +
                "from TourGroup tg join tg.passenger p " +
                "where tg.id = :tourGroupId";

        Query query = entityManager.createQuery(
                "select count(*) from (" + subQuery + ") as sub " +
                        "where sub.years < 18");

        return (Integer) query.setParameter("tourGroupId", tourGroupId).getSingleResult();
    }

    //Взрослые
    @Override
    public Integer countPassengersBefore18InTourGroup(Integer tourGroupId) {

        String subQuery = "select (extract(year from current_date) - extract(year from p.birthday)) as years " +
                "from TourGroup tg join tg.passenger p " +
                "where tg.id = :tourGroupId";

        Query query = entityManager.createQuery(
                "select count(*) from (" + subQuery + ") as sub " +
                        "where sub.years >= 18");

        return (Integer) query.setParameter("tourGroupId", tourGroupId).getSingleResult();
    }



}
