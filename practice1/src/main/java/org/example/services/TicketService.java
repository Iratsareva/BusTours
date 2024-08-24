package org.example.services;


import org.example.dto.TicketDTO;

import java.util.List;

public interface TicketService {
    TicketDTO addTicket (TicketDTO ticketDTO);
    TicketDTO getTicketById(int id);
    List<TicketDTO> findAll();

    Boolean freeTicketsInTrip (int idTrip);

    TicketDTO buyingTicketByTrip (int idTrip, int idPassenger);

}
