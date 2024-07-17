package org.example.dto;

public class TourDTO {
    public String nameTour;
    public String description;
    public String itinerary;
    public int lengthTour;
    public int price;
    public String destination;

    public TourDTO(){}
    public TourDTO(String nameTour, String description, String itinerary, int lengthTour, int price, String destination) {
        this.nameTour = nameTour;
        this.description = description;
        this.itinerary = itinerary;
        this.lengthTour = lengthTour;
        this.price = price;
        this.destination = destination;
    }

    public String getNameTour() {
        return nameTour;
    }

    public void setNameTour(String nameTour) {
        this.nameTour = nameTour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItinerary() {
        return itinerary;
    }

    public void setItinerary(String itinerary) {
        this.itinerary = itinerary;
    }

    public int getLengthTour() {
        return lengthTour;
    }

    public void setLengthTour(int lengthTour) {
        this.lengthTour = lengthTour;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
