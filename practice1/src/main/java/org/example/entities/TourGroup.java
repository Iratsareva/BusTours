package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tour_group")
public class TourGroup extends BaseEntity {
    private Passenger passenger;
    private Trip trip;


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
}
