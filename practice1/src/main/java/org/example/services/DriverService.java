package org.example.services;

import org.example.domain.Driver;

public interface DriverService {
    void addDriver(Driver driver);
    Driver getDriverById(int id);

}
