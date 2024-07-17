package org.example.controller;

import org.example.domain.Driver;
import org.example.dto.BusDTO;
import org.example.dto.DriverDTO;
import org.example.dto.TripDTO;
import org.example.services.BusService;
import org.example.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trip")
public class TripController {
    @Autowired
    private TripService tripService;

    @PostMapping("/add")
    void addTrip(@RequestBody TripDTO tripDTO){
        tripService.addTrip(tripDTO);
    }

    @GetMapping("/{id}")
    public TripDTO getTripById (@PathVariable int id){
        return tripService.getTripById(id);
    }

    @GetMapping("/DriverToTrip")
    public List<DriverDTO> findDriverToTrip(@PathVariable TripDTO tripDTO){
        return tripService.findDriverToTrip(tripDTO);
    }

}
