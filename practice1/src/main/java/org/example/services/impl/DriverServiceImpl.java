package org.example.services.impl;

import org.example.domain.Driver;
import org.example.repositories.DriverRepository;
import org.example.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;

public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepository driverRepository;

    @Override
    public void addDriver(Driver driver) {
        driverRepository.create(driver);
    }

    @Override
    public Driver getDriverById(int id) {
        return driverRepository.findById(Driver.class, id);
    }
}
