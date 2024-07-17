package org.example.controller;

import org.example.dto.PassengerDTO;
import org.example.dto.TourDTO;
import org.example.dto.TourGroupDTO;
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
    void addTour(@RequestBody TourDTO tourDTO){
        tourService.addTour(tourDTO);
    }

    @GetMapping("/{id}")
    public TourDTO getTourById (@PathVariable int id){
        return tourService.getTourById(id);
    }


    @GetMapping("/recommendation")
    public List<TourDTO> getRecommendationsTour(@PathVariable PassengerDTO passengerDTO){
        return tourService.getRecommendationsTour(passengerDTO);
    }


    @GetMapping("/tourTourGroup")
    public List<TourDTO> getTourForTourGroup(@PathVariable TourGroupDTO tourGroupDTO){
        return tourService.getTourForTourGroup(tourGroupDTO);
    }
}
