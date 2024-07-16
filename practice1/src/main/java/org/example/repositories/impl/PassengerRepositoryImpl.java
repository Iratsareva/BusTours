package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.domain.Passenger;
import org.example.domain.TourGroup;
import org.example.repositories.AbstractRepository;
import org.example.repositories.PassengerRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PassengerRepositoryImpl extends AbstractRepository<Passenger> implements PassengerRepository {
}
