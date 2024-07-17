package org.example.controller;


import org.example.dto.BusDTO;
import org.example.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @PostMapping("/add")
    void addBus(@RequestBody BusDTO busDTO){
        busService.addBus(busDTO);
    }

    @GetMapping("/{id}")
    public BusDTO getBusById (@PathVariable int id){
        return busService.getBusById(id);
    }



}
