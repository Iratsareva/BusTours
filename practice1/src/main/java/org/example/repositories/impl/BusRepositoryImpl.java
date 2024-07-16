package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.domain.Bus;
import org.example.repositories.AbstractRepository;
import org.example.repositories.BusRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BusRepositoryImpl extends AbstractRepository<Bus> implements BusRepository {
}
