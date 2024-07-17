package org.example.services;

import org.example.domain.Bus;
import org.example.dto.BusDTO;

public interface BusService {
    void addBus (BusDTO busDTO);
    BusDTO getBusById(int id);


}
