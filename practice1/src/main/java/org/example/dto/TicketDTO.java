package org.example.dto;

import org.example.domain.TicketStatus;

public class TicketDTO {
    public int id;
    public int passengerId;
    public int tripId;
    public int price;
    public TicketStatus ticketStatus;

    public TicketDTO(){}
    public TicketDTO(int id, int passengerId, int tripId, int price, TicketStatus ticketStatus) {
        this.id = id;
        this.passengerId = passengerId;
        this.tripId = tripId;
        this.price = price;
        this.ticketStatus = ticketStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
