package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tour_group")
public class TourGroup {
    private Passenger passenger;
    private Tour tour;


    @ManyToOne
    @JoinColumn(name = "id_passenger")
    public Passenger getPassenger() {
        return passenger;
    }
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }


    @ManyToOne
    @JoinColumn(name = "id_tour")
    public Tour getTour() {
        return tour;
    }
    public void setTour(Tour tour) {
        this.tour = tour;
    }
}
