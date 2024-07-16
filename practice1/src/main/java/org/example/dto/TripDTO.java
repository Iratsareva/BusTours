package org.example.dto;

import org.example.domain.Bus;
import org.example.domain.Driver;
import org.example.domain.Tour;

import java.time.LocalDate;

public class TripDTO {
    public int tourId;
    public int busId;
    public int driverId;
    public LocalDate startDate;
    public LocalDate endDate;
}
