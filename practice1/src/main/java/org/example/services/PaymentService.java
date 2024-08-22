package org.example.services;

import org.example.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {

    PaymentDTO addPayment (PaymentDTO paymentDTO);
    PaymentDTO getPaymentById(int id);
    List<PaymentDTO> findAll();
    PaymentDTO paymentTicket (int idTicket);
}
