package org.example.entities;

import jakarta.persistence.*;

@Entity @Table(name = "bus_driver_tour")
public class BusDriverTour {
    private Tour tour;
    private Bus bus;
    private Driver driver;


    @ManyToOne
    @JoinColumn(name = "id_tour")
    public Tour getTour() {
        return tour;
    }
    public void setTour(Tour tour) {
        this.tour = tour;
    }

    @ManyToOne
    @JoinColumn(name = "id_bus")
    public Bus getBus() {
        return bus;
    }
    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @ManyToOne
    @JoinColumn(name = "id_driver")
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

}
