package org.example.controller;

import org.example.dto.TicketDTO;
import org.example.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;


    @PostMapping("/add")
    public TicketDTO addTicket(@RequestBody TicketDTO ticketDTO){
        return ticketService.addTicket(ticketDTO);
    }

    @GetMapping("/{id}")
    public TicketDTO getTicketById (@PathVariable int id){
        return ticketService.getTicketById(id);
    }

    @GetMapping("/all")
    Iterable<TicketDTO> getAll() {
        return ticketService.findAll();
    }



    @GetMapping("/freeTicketsInTrip/{id}")
    ResponseEntity<String> freeTicketsInTrip(@PathVariable int id){
        Boolean checkFreeTickets = ticketService.freeTicketsInTrip(id);
        if(checkFreeTickets) return ResponseEntity.ok("На этот рейс еще есть билеты");
        else return  ResponseEntity.ok("Наэтот рейс уже нет билетов");
    }

    @GetMapping("/buy/{idPassenger}/{idTrip}")
    ResponseEntity<String> buyingTicketByTrip (@PathVariable int idTrip,
                                               @PathVariable int idPassenger){
        Boolean checkFreeTickets = ticketService.freeTicketsInTrip(idTrip);
        TicketDTO ticketDTO = ticketService.buyingTicketByTrip(idTrip, idPassenger);

        if(!checkFreeTickets) return ResponseEntity.ok("Наэтот рейс уже нет билетов");
        else if(ticketDTO == null) return ResponseEntity.ok("На этот рейс уже нельзя купить билеты");
        else return ResponseEntity.ok("Билет на рейс " + idTrip + " успешно оформлен! \nНомер билета " + ticketDTO.getId() + " сумма к оплате: " + ticketDTO.getPrice());
    }
}
