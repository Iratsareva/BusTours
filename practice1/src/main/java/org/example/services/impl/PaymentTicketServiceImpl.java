package org.example.services.impl;

import org.example.domain.*;
import org.example.dto.PaymentDTO;
import org.example.exception.PasNotFoundException;
import org.example.repositories.PaymentRepository;
import org.example.repositories.TicketRepository;
import org.example.repositories.TripRepository;
import org.example.services.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentTicketServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private TicketRepository ticketRepository;


    private ModelMapper modelMapper = new ModelMapper();


    @Transactional
    @Override
    public PaymentDTO addPayment(PaymentDTO paymentDTO) {
        Payment payment = modelMapper.map(paymentDTO, Payment.class);
        return modelMapper.map(paymentRepository.create(payment), PaymentDTO.class);
    }

    @Override
    public PaymentDTO getPaymentById(int id) {
        Payment p = paymentRepository.findById(Payment.class, id);
        return modelMapper.map(p, PaymentDTO.class);
    }

    @Override
    @Transactional
    public List<PaymentDTO> findAll() {
        for (Payment payment : paymentRepository.getAll(Payment.class)){
            LocalDate start = payment.getTicket().getTrip().getStartDate().minusDays(1);

            if(payment.getPaymentDate() == null && start.isBefore(LocalDate.now())){
                payment.setPaymentStatus(PaymentStatus.OVERDUE);
                payment.getTicket().setTicketStatus(TicketStatus.CANCELLED);
            }
        }

        return paymentRepository.getAll(Payment.class).stream().map(payment ->
                modelMapper.map(payment, PaymentDTO.class)).toList();
    }


    @Override
    @Transactional
    public PaymentDTO paymentTicket (int idTicket){
        Payment payment = paymentRepository.findPaymentByTicket(idTicket);
        Ticket ticket = ticketRepository.findById(Ticket.class, idTicket);
        if (ticket == null) {
            throw new PasNotFoundException("Такого билета не существует");
        }
        Trip trip = tripRepository.findTripByTicket(idTicket);
        LocalDate start = trip.getStartDate().minusDays(1);

        if (payment.getPaymentStatus()==PaymentStatus.AWAITING) {
            if (start.isAfter(LocalDate.now())) {

                payment.setPaymentDate(LocalDate.now());
                payment.setPaymentStatus(PaymentStatus.COMPLETED);

                ticket.setTicketStatus(TicketStatus.CONFIRMED);
            } else {
                payment.setPaymentStatus(PaymentStatus.OVERDUE);
                ticket.setTicketStatus(TicketStatus.CANCELLED);
            }
        }
        return modelMapper.map(payment,PaymentDTO.class);
    }
}
