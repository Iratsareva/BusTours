package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.domain.Bus;
import org.example.repositories.AbstractRepository;
import org.example.repositories.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BusRepositoryImpl extends AbstractRepository<Bus> implements BusRepository {

    @PersistenceContext
    private EntityManager entityManager;
//    @Autowired
//    private BaseBusRepo baseBusRepo;


}

//interface BaseBusRepo extends JpaRepository<Bus, Integer> {
//
//}