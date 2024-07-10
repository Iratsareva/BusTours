package org.example;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity @Table(name = "tour")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tour")
    private int id_tour;

    @Column(name = "name_tour")
    private String name_tour;

    @Column(name = "description")
    private String description;

    @Column(name = "date_tour")
    private LocalDate date_tour;

    @Column(name = "itinerary")
    private String itinerary;

    @Column(name = "length_tour")
    private int length_tour;

    @Column(name = "price")
    private int price;

    public int getId_tour() {
        return id_tour;
    }

    public void setId_tour(int id_tour) {
        this.id_tour = id_tour;
    }

    public String getName_tour() {
        return name_tour;
    }

    public void setName_tour(String name_tour) {
        this.name_tour = name_tour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate_tour() {
        return date_tour;
    }

    public void setDate_tour(LocalDate date_tour) {
        this.date_tour = date_tour;
    }

    public String getItinerary() {
        return itinerary;
    }

    public void setItinerary(String itinerary) {
        this.itinerary = itinerary;
    }

    public int getLength_tour() {
        return length_tour;
    }

    public void setLength_tour(int length_tour) {
        this.length_tour = length_tour;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

