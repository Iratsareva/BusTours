package org.example.controller;

import org.example.dto.DriverDTO;
import org.example.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/add")
    public DriverDTO addDriver(@RequestBody DriverDTO driverDTO){
        return driverService.addDriver(driverDTO);
    }

    @GetMapping("/{id}")
    public DriverDTO getDriverById (@PathVariable int id){
        return driverService.getDriverById(id);
    }


    @GetMapping("/all")
    Iterable<DriverDTO> getAll() {
        return driverService.findAll();
    }

    @GetMapping("/find/{id}")
    Iterable<DriverDTO> findFreeDriversByTripId (@PathVariable int id){
        return driverService.findFreeDriversByTripId(id);
    }


}
