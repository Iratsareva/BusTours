package org.example.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity @Table(name = "tour")
public class Tour extends BaseEntity {
    private String nameTour;
    private String description;
    private String itinerary;
    private int lengthTour;
    private int price;
    private String destination;

    private Set<Trip> trips;


    public Tour(String nameTour, String description, String itinerary, int lengthTour, int price, String destination) {
        this.nameTour = nameTour;
        this.description = description;
        this.itinerary = itinerary;
        this.lengthTour = lengthTour;
        this.price = price;
        this.destination = destination;
    }

    protected Tour(){}

    @Column(name = "name_tour")
    public String getNameTour() {
        return nameTour;
    }
    public void setNameTour(String nameTour) {
        this.nameTour = nameTour;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }




    @Column(name = "itinerary")
    public String getItinerary() {
        return itinerary;
    }
    public void setItinerary(String itinerary) {
        this.itinerary = itinerary;
    }



    @Column(name = "length_tour")
    public int getLengthTour() {
        return lengthTour;
    }

    public void setLengthTour(int lengthTour) {
        this.lengthTour = lengthTour;
    }


    @Column(name = "price")
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name = "destination")
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @OneToMany(mappedBy = "tour", targetEntity = Trip.class,
    fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }
}

