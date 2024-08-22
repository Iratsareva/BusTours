package org.example.services.impl;

import org.example.domain.Bus;
import org.example.dto.BusDTO;
import org.example.repositories.BusRepository;
import org.example.services.BusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Transactional
    @Override
    public BusDTO addBus(BusDTO busDTO) {
        Bus bus = modelMapper.map(busDTO, Bus.class);
        return modelMapper.map(busRepository.create(bus), BusDTO.class);
    }

    @Override
    public BusDTO getBusById(int id) {
        Bus b = busRepository.findById(Bus.class,id);
        return modelMapper.map(b, BusDTO.class);
    }

    @Override
    @Transactional
    public List<BusDTO> findAll() {
        return busRepository.getAll(Bus.class).stream().map(bus ->
                modelMapper.map(bus, BusDTO.class)).toList();
    }




}
