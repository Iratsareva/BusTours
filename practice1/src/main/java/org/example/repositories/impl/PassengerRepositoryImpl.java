package org.example.repositories.impl;

import org.example.domain.Passenger;
import org.example.repositories.AbstractRepository;
import org.example.repositories.PassengerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PassengerRepositoryImpl extends AbstractRepository<Passenger> implements PassengerRepository {
}
