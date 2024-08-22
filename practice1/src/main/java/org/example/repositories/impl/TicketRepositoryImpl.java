package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.domain.Ticket;
import org.example.repositories.AbstractRepository;
import org.example.repositories.TicketRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketRepositoryImpl extends AbstractRepository<Ticket> implements TicketRepository {

    @PersistenceContext
    private EntityManager entityManager;


    // поиск всех билетов на оопределенный рейс
    @Override
    public List<Ticket> TicketsTrip(Integer idTrip){
        TypedQuery<Ticket> query = entityManager.createQuery(
                "select ti from Ticket ti " +
                        "join ti.trip tr " +
                        "where tr.id = :id ", Ticket.class);
        return query.setParameter("id", idTrip).getResultList();
    }
}
