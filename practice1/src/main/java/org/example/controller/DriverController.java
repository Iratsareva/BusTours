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

    @PostMapping("/driver/add")
    void addDriver(@RequestBody DriverDTO driverDTO){
        driverService.addDriver(driverDTO);
    }

    @GetMapping("/{id}")
    public DriverDTO getDriverById (@PathVariable int id){
        return driverService.getDriverById(id);
    }

}
