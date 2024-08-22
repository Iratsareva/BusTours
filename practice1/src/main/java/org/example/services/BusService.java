package org.example.services;

import org.example.dto.BusDTO;

import java.util.List;

public interface BusService {
    BusDTO addBus (BusDTO busDTO);
    BusDTO getBusById(int id);
    List<BusDTO> findAll();

}
