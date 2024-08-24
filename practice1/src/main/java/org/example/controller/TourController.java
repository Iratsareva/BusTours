package org.example.controller;

import org.example.dto.TourDTO;
import org.example.dto.TripDTO;
import org.example.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tour")
public class TourController {
    @Autowired
    private TourService tourService;

    @PostMapping("/add")
    public TourDTO addTour(@RequestBody TourDTO tourDTO){
        return tourService.addTour(tourDTO);
    }

    @GetMapping("/{id}")
    public TourDTO getTourById (@PathVariable int id){
        return tourService.getTourById(id);
    }

    @GetMapping("/all")
    Iterable<TourDTO> getAll() {
        return tourService.findAll();
    }

    @GetMapping("/find")
    Iterable<TripDTO> findTourByDestination (@RequestParam String destination,
                                             @RequestParam Integer numberPassengers ){
        return tourService.findTourByParameters(destination,numberPassengers );
    }
}
