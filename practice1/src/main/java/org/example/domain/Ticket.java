package org.example.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "ticket")
public class Ticket extends BaseEntity {

    private Passenger passenger;
    private Trip trip;
    private int price;
    private TicketStatus ticketStatus;

    private Set<Payment> payments;


    public Ticket(Passenger passenger, Trip trip, int price, TicketStatus ticketStatus) {
        this.passenger = passenger;
        this.trip = trip;
        this.price = price;
        this.ticketStatus = ticketStatus;
    }

    protected Ticket(){}

    @ManyToOne
    @JoinColumn(name = "id_passenger", referencedColumnName = "id")
    public Passenger getPassenger() {
        return passenger;
    }
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }


    @ManyToOne
    @JoinColumn(name = "id_trip", referencedColumnName = "id")
    public Trip getTrip() {
        return trip;
    }
    public void setTrip(Trip trip) {
        this.trip = trip;
    }


    @Column(name = "price")
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }



    @Column(name = "ticket_status")
    @Enumerated(EnumType.STRING)
    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }
    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }



    @OneToMany(mappedBy = "ticket", targetEntity = Payment.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Payment> getPayments() {
        return payments;
    }
    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }
}
