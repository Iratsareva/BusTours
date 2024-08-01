package org.example.domain;

import jakarta.persistence.*;

@Entity @Table(name = "tour_group")
public class TourGroup  {

    private int id;
    private Passenger passenger;
    private Trip trip;

    public TourGroup(Integer id, Passenger passenger, Trip trip) {
        this.id = id;
        this.passenger = passenger;
        this.trip = trip;
    }

    protected TourGroup(){}

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    @Id
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
