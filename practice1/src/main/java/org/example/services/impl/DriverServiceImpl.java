package org.example.services.impl;

import org.example.domain.Driver;
import org.example.domain.Tour;
import org.example.domain.Trip;
import org.example.dto.DriverDTO;
import org.example.exception.PasNotFoundException;
import org.example.repositories.DriverRepository;
import org.example.repositories.TourRepository;
import org.example.repositories.TripRepository;
import org.example.services.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private TripRepository tripRepository;


    private ModelMapper modelMapper = new ModelMapper();

    @Transactional
    @Override
    public DriverDTO addDriver(DriverDTO driverDTO) {
        Driver driver = modelMapper.map(driverDTO, Driver.class);
        return modelMapper.map(driverRepository.create(driver), DriverDTO.class);
    }

    @Override
    public DriverDTO getDriverById(int id) {
        Driver d = driverRepository.findById(Driver.class, id);
        return modelMapper.map(d, DriverDTO.class);
    }

    @Override
    @Transactional
    public List<DriverDTO> findAll() {
        return driverRepository.getAll(Driver.class).stream().map(driver ->
                modelMapper.map(driver, DriverDTO.class)).toList();
    }



    @Override
    @Transactional
    public List<DriverDTO> findFreeDriversByTripId(Integer tripId) {
        List<Trip> tripList = tripRepository.getAll(Trip.class);
        Trip trip = tripRepository.findById(Trip.class, tripId);
        if(trip == null){
            throw new PasNotFoundException("Такого рейса не существует");
        }
        Tour tour = tourRepository.findTourByTrip(tripId);
        List<Driver> findDrivers = new ArrayList<>();

        List<Driver> drivers =  driverRepository.getAll(Driver.class);

        //занятые водители
        List<Driver> busyDrivers = new ArrayList<>();
        for (Trip t : tripList){
            if (t.getEndDate().isAfter(trip.getStartDate()) || t.getEndDate().isEqual(trip.getStartDate())){
                if (t.getStartDate().isBefore(trip.getEndDate()) || t.getStartDate().isEqual(trip.getStartDate()) ){
                    busyDrivers.add(driverRepository.findDriverByTrip(t.getId()));
                    //свободные
                    drivers.remove(driverRepository.findDriverByTrip(t.getId()));
                }
            }
        }













        //если продолжительность маршрута больше 10 дней стаж видителя должен быть больше 10 лет
        if(tour.getLengthTour()>10) {
            for (Driver driver : drivers) {
                int c = LocalDate.now().getYear() - driver.getDateStartDriverLicense().getYear();
                if (c > 10) {
                    findDrivers.add(driver);
                }
            }

        }else {
            findDrivers = drivers;
        }


        return findDrivers.stream().map(driver -> modelMapper.map(driver,DriverDTO.class)).toList();
    }


}
