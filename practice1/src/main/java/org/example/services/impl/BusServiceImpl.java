package org.example.services.impl;

import org.example.domain.Bus;
import org.example.repositories.BusRepository;
import org.example.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;

public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Override
    public void addBus(Bus bus) {
        busRepository.create(bus);
    }

    @Override
    public Bus getBusById(int id) {
        return busRepository.findById(Bus.class,id);
    }
}
