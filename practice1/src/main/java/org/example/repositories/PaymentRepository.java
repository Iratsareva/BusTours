package org.example.repositories;

import org.example.domain.Payment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository {
    Payment create(Payment payment);
    Payment findById(Class<Payment> paymentClass, int id);
    List<Payment> getAll(Class<Payment> paymentClass);

    Payment findPaymentByTicket (Integer idTicket);
}
