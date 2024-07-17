package org.example.dto;

import org.example.domain.Passenger;
import org.example.domain.Trip;

public class TourGroupDTO {
    public int passengerId;
    public int tripId;

    public TourGroupDTO(){}
    public TourGroupDTO(int passengerId, int tripId) {
        this.passengerId = passengerId;
        this.tripId = tripId;
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
