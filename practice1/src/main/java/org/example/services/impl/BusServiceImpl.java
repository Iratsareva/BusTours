package org.example.services.impl;

import org.example.domain.Bus;
import org.example.dto.BusDTO;
import org.example.repositories.BusRepository;
import org.example.services.BusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public void addBus(BusDTO busDTO) {
        Bus bus = modelMapper.map(busDTO, Bus.class);
        busRepository.create(bus);
    }

    @Override
    public BusDTO getBusById(int id) {
        Bus b = busRepository.findById(Bus.class,id);
        return modelMapper.map(b, BusDTO.class);
    }
}
