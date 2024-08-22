package org.example.repositories;

import org.example.domain.Bus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository  {
    Bus create(Bus bus);
    Bus findById(Class<Bus> busClass, int id);
    List<Bus> getAll(Class<Bus> busClass);

    Bus findBusByTrip (Integer idTrip);



}
