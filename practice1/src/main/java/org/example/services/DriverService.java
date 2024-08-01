package org.example.services;

import org.example.dto.DriverDTO;

public interface DriverService {
    void addDriver(DriverDTO driverDTO);
    DriverDTO getDriverById(int id);

}
