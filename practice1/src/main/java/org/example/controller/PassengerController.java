package org.example.controller;

import org.example.dto.BusDTO;
import org.example.dto.DriverDTO;
import org.example.dto.PassengerDTO;
import org.example.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/passenger")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;



    @PostMapping("/passenger/add")
    void addPassenger(@RequestBody PassengerDTO passengerDTO){
        passengerService.addPassenger(passengerDTO);
    }

    @GetMapping("/{id}")
    public PassengerDTO getPassengerById (@PathVariable int id){
        return passengerService.getPassengerById(id);
    }

}