package org.example.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "payment")
public class Payment extends BaseEntity{

    private Ticket ticket;
    private LocalDate paymentDate;
    private PaymentStatus paymentStatus;

    public Payment(Ticket ticket, LocalDate paymentDate, PaymentStatus paymentStatus) {
        this.ticket = ticket;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
    }

    protected Payment(){}

    @ManyToOne
    @JoinColumn(name = "id_ticket", referencedColumnName = "id")
    public Ticket getTicket() {
        return ticket;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }


    @Column(name = "payment_date")
    public LocalDate getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
