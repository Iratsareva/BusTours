package org.example.services.impl;

import org.example.domain.*;
import org.example.dto.TicketDTO;
import org.example.exception.PasNotFoundException;
import org.example.repositories.*;
import org.example.services.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private PaymentRepository paymentRepository;


    private ModelMapper modelMapper = new ModelMapper();

    @Transactional
    @Override
    public TicketDTO addTicket (TicketDTO ticketDTO){
        Ticket ticket = modelMapper.map(ticketDTO, Ticket.class);
        return modelMapper.map(ticketRepository.create(ticket), TicketDTO.class);
    }

    @Override
    public TicketDTO getTicketById(int id){
        Ticket t = ticketRepository.findById(Ticket.class, id);
        return modelMapper.map(t,TicketDTO.class);
    }

    @Override
    @Transactional
    public List<TicketDTO> findAll() {
        return ticketRepository.getAll(Ticket.class).stream().map(ticket ->
                modelMapper.map(ticket, TicketDTO.class)).toList();
    }


    //удалить
    @Override
    @Transactional
    public List<TicketDTO> findTicketsByTrip(int idTrip){
        List<Ticket> ticketList = ticketRepository.TicketsTrip(idTrip);
        return ticketList.stream().map(ticket -> modelMapper.map(ticket, TicketDTO.class)).toList();
    }


    //есть ли свободные билеты на Рейс
    //удалить
    @Override
    @Transactional
    public Boolean freeTicketsInTrip (int idTrip){
        List<Ticket> ticketList = ticketRepository.TicketsTrip(idTrip);
        Bus b = busRepository.findBusByTrip(idTrip);
        return (ticketList.size() < b.getNumberSeats());
    }


    @Override
    @Transactional
    public TicketDTO buyingTicketByTrip (int idTrip, int idPassenger){
        Trip trip = tripRepository.findById(Trip.class, idTrip);
        if (trip == null) {
            throw new PasNotFoundException("Такого тура не существует");
        }

        Passenger passenger = passengerRepository.findById(Passenger.class, idPassenger);
        if (passenger == null) {
            throw new PasNotFoundException("Такого пассажира не существует");
        }

        LocalDate start = trip.getStartDate().minusDays(1);

        List<Ticket> ticketList = ticketRepository.TicketsTrip(idTrip);
        Bus b = busRepository.findBusByTrip(idTrip);


        // Проверяем есть ли билеты на этот рейс
        if (ticketList.size() < b.getNumberSeats()) {


            //Проверяем что данный рейс еще не отправился и что его ще можно оплатить( за сутки до старта)
            if (start.isAfter(LocalDate.now())) {

                int price = trip.getTour().getPrice()/trip.getBus().getNumberSeats();
                Ticket ticket = new Ticket(passenger, trip, price, TicketStatus.AWAITING);
                ticketRepository.create(ticket);

                Payment payment = new Payment(ticket, null, PaymentStatus.AWAITING);
                paymentRepository.create(payment);

                return modelMapper.map(ticket, TicketDTO.class);

            } else {
                System.out.println("Ошибка даты рейса");
                return null;
            }
        }
        System.out.println("Ошибка количество билетов");


        return null;

    }


}
