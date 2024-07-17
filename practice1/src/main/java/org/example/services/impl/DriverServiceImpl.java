package org.example.services.impl;

import org.example.domain.Driver;
import org.example.dto.BusDTO;
import org.example.dto.DriverDTO;
import org.example.repositories.DriverRepository;
import org.example.services.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepository driverRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public void addDriver(DriverDTO driverDTO) {
        Driver driver = modelMapper.map(driverDTO, Driver.class);
        driverRepository.create(driver);
    }

    @Override
    public DriverDTO getDriverById(int id) {
        Driver d = driverRepository.findById(Driver.class, id);
        return modelMapper.map(d, DriverDTO.class);
    }
}
