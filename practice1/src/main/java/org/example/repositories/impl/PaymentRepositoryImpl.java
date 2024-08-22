package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.domain.Payment;
import org.example.repositories.AbstractRepository;
import org.example.repositories.PaymentRepository;
import org.springframework.stereotype.Repository;


@Repository
public class PaymentRepositoryImpl extends AbstractRepository<Payment> implements PaymentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Payment findPaymentByTicket (Integer idTicket){
        TypedQuery<Payment> query = entityManager.createQuery(
                "select p from Payment p " +
                        "join p.ticket t " +
                        "where t.id = :id",Payment.class);
        return query.setParameter("id", idTicket).getSingleResult();
    }

}
