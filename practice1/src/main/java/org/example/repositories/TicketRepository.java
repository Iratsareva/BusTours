package org.example.repositories;

import org.example.domain.Ticket;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository {

    Ticket create(Ticket ticket);
    Ticket findById(Class<Ticket> ticketClass, int id);
    List<Ticket> getAll(Class<Ticket> ticketClass);

    List<Ticket> TicketsTrip(Integer idTrip);
}
