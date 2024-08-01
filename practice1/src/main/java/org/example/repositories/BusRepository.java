package org.example.repositories;

import org.example.domain.Bus;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository  {
    void create(Bus bus);
    Bus findById(Class<Bus> busClass, int id);
    Bus update (Bus bus);
}
