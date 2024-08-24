package org.example.repositories;


import org.example.domain.Driver;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository  {
    Driver findDriverByTrip(Integer tripId);
    Driver create(Driver driver);
    Driver findById(Class<Driver> driverClass, int id);
    List<Driver> getAll(Class<Driver> driverClass);
}
