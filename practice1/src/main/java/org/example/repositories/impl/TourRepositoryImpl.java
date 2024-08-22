package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.domain.Tour;
import org.example.repositories.AbstractRepository;
import org.example.repositories.TourRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TourRepositoryImpl extends AbstractRepository<Tour> implements TourRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Tour> findTourByDestination(String destination){
        TypedQuery<Tour> query = entityManager.createQuery(
                "select t from Tour t " +
                        "where t.destination = :destination", Tour.class);
        return query.setParameter("destination", destination).getResultList();
    }


    @Override
    public Tour findTourByTrip (int idTrip){
        TypedQuery<Tour> query = entityManager.createQuery(
                "select t from Tour t " +
                        "join t.trips tr " +
                        "where tr.id = :id", Tour.class);
        return query.setParameter("id", idTrip).getSingleResult();
    }


//    //Найти похожие туры на основе посещенных
//    @Override
//    public List<Tour> findToursByPassengerId(Integer passengerId) {
//        String subQuery = "from TourGroup tg " +
//                "join tg.trip t " +
//                "where tg.passenger.id = :passengerId";
//        TypedQuery<Tour> query = entityManager.createQuery(
//                "select t from Tour t where t.id not in " +
//                        "(select t.tour.id "+ subQuery+ ") " +
//                        "and (t.length = any" +
//                        "(select tg.tour.length "+ subQuery+
//                        "or t.price = any" +
//                        "(select tg.tour.price "+ subQuery+
//                        "or t.destination = any" +
//                        "(select tg.tour.destination "+ subQuery,Tour.class);
//        return query.setParameter("passengerId", passengerId).getResultList();
//
//    }
//
//    // Подбор тура для детей или для взрослых по продолжительности
//    @Override
//    public List<Tour> findToursByTourGroup(Integer children, Integer adults) {
//        if (children >adults) {
//            TypedQuery<Tour> query = entityManager.createQuery(
//                    "select t from Tour t " +
//                            "where t.length_tour <= 3", Tour.class);
//            return query.getResultList();
//        }else {
//            TypedQuery<Tour> query = entityManager.createQuery(
//                    "select t from Tour t " +
//                            "where t.length_tour >= 3", Tour.class);
//            return query.getResultList();
//        }
//    };
//

}
