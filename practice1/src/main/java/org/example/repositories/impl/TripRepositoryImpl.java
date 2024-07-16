package org.example.repositories.impl;

import org.example.domain.*;
import org.example.repositories.AbstractRepository;
import org.example.repositories.TripRepository;
import org.springframework.stereotype.Repository;


@Repository
public class TripRepositoryImpl extends AbstractRepository<Trip> implements TripRepository {
}
