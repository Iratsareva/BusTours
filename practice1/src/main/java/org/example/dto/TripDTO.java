package org.example.dto;

import org.example.domain.TripStatus;

import java.time.LocalDate;

public class TripDTO {
    public int id;
    public int tourId;
    public int busId;
    public int driverId;
    public LocalDate startDate;
    public LocalDate endDate;

    public TripStatus tripStatus;

    public TripDTO(){}
    public TripDTO(int id, int tourId, int busId, int driverId, LocalDate startDate, LocalDate endDate, TripStatus tripStatus) {
        this.id = id;
        this.tourId = tourId;
        this.busId = busId;
        this.driverId = driverId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tripStatus = tripStatus;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
