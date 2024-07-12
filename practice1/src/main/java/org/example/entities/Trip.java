package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity @Table(name = "trip")
public class Trip extends BaseEntity {
    private Tour tour;
    private Bus bus;
    private Driver driver;
    private LocalDate startDate;
    private LocalDate endDate;



    @ManyToOne
    @JoinColumn(name = "id_tour", referencedColumnName = "id")
    public Tour getTour() {
        return tour;
    }
    public void setTour(Tour tour) {
        this.tour = tour;
    }

    @ManyToOne
    @JoinColumn(name = "id_bus", referencedColumnName = "id")
    public Bus getBus() {
        return bus;
    }
    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @ManyToOne
    @JoinColumn(name = "id_driver", referencedColumnName = "id")
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Column(name = "start_date")
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Column(name = "end_date")
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
