package org.example.controller;


import org.example.dto.BusDTO;
import org.example.dto.TourGroupDTO;
import org.example.services.BusService;
import org.example.services.TourGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tourGroup")
public class TourGroupController {

    @Autowired
    private TourGroupService tourGroupService;

    @PostMapping("/add")
    void addTourGroup(@RequestBody TourGroupDTO tourGroupDTO){
        tourGroupService.addTourGroup(tourGroupDTO);
    }

    @GetMapping("/{id}")
    public TourGroupDTO getTourGroupById (@PathVariable int id){
        return tourGroupService.getTourGroupById(id);
    }



}
