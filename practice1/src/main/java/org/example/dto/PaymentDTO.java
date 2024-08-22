package org.example.dto;

import org.example.domain.PaymentStatus;

import java.time.LocalDate;

public class PaymentDTO {

    public int id;
    public int ticketId;
    public LocalDate paymentDate;
    public PaymentStatus paymentStatus;

    public PaymentDTO(){}
    public PaymentDTO(int id, int ticketId, LocalDate paymentDate, PaymentStatus paymentStatus) {
        this.id = id;
        this.ticketId = ticketId;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
