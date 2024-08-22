package org.example.services;

import org.example.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    DriverDTO addDriver(DriverDTO driverDTO);
    DriverDTO getDriverById(int id);
    List<DriverDTO> findAll();

    List<DriverDTO> findFreeDriversByTripId(Integer tripId);

}
