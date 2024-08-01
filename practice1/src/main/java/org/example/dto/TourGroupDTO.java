package org.example.dto;

import org.example.domain.Passenger;
import org.example.domain.Trip;

public class TourGroupDTO {

    public Integer id;
    public int passengerId;
    public int tripId;

    public TourGroupDTO(){}
    public TourGroupDTO(Integer id, int passengerId, int tripId) {
        this.id = id;
        this.passengerId = passengerId;
        this.tripId = tripId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
