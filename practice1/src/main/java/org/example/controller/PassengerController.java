package org.example.controller;

import org.example.dto.PassengerDTO;
import org.example.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/passenger")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping("/add")
    public PassengerDTO addPassenger(@RequestBody PassengerDTO passengerDTO){
        return passengerService.addPassenger(passengerDTO);
    }

    @GetMapping("/{id}")
    public PassengerDTO getPassengerById (@PathVariable int id){
        return passengerService.getPassengerById(id);
    }

    @GetMapping("/all")
    Iterable<PassengerDTO> getAll() {
        return passengerService.findAll();
    }
}