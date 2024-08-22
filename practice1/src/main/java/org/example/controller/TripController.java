package org.example.controller;

import org.example.dto.TripDTO;
import org.example.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trip")
public class TripController {
    @Autowired
    private TripService tripService;

    @PostMapping("/add")
    public TripDTO addTrip(@RequestBody TripDTO tripDTO){
        return tripService.addTrip(tripDTO);
    }

    @GetMapping("/{id}")
    public TripDTO getTripById (@PathVariable int id){
        return tripService.getTripById(id);
    }


    @GetMapping("/all")
    Iterable<TripDTO> getAll() {
        return tripService.findAll();
    }

//    @GetMapping("/DriverToTrip")
//    public List<DriverDTO> findDriverToTrip(@PathVariable TripDTO tripDTO){
//        return tripService.findDriverToTrip(tripDTO);
//    }
}
