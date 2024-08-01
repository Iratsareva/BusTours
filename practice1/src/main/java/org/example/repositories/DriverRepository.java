package org.example.repositories;


import org.example.domain.Driver;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DriverRepository  {

    List<Driver> findDriversByTripId(Integer tripId);

    void create(Driver driver);
    Driver findById(Class<Driver> driverClass, int id);
    Driver update(Driver driver);

}
