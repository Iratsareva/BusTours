package org.example.services.impl;

import org.example.domain.Bus;
import org.example.domain.Ticket;
import org.example.domain.Tour;
import org.example.domain.Trip;
import org.example.dto.TourDTO;
import org.example.dto.TripDTO;
import org.example.exception.PasNotFoundException;
import org.example.repositories.BusRepository;
import org.example.repositories.TicketRepository;
import org.example.repositories.TourRepository;
import org.example.repositories.TripRepository;
import org.example.services.TourService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class TourServiceImpl implements TourService {
    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private BusRepository busRepository;



    private ModelMapper modelMapper = new ModelMapper();

    @Transactional
    @Override
    public TourDTO addTour(TourDTO tourDTO) {
        Tour tour = modelMapper.map(tourDTO, Tour.class );
        return modelMapper.map(tourRepository.create(tour), TourDTO.class);
    }


    @Override
    public TourDTO getTourById(int id) {
        Tour t = tourRepository.findById(Tour.class, id);
        return modelMapper.map(t, TourDTO.class);
    }

    @Override
    @Transactional
    public List<TourDTO> findAll() {
        return tourRepository.getAll(Tour.class).stream().map(tour ->
                modelMapper.map(tour, TourDTO.class)).toList();
    }



//метод для поиска тура по месту назначения которые сейчас можно купить
    @Override
    @Transactional
    public List<TripDTO> findTourByParameters (String destination, Integer numberPassengers){

        //находим тур по месту назначения
        List<Tour> tourList = tourRepository.findTourByDestination(destination);
        if(tourList.isEmpty()){
            throw new PasNotFoundException("Такого тура не существует");
        }

        List<Trip> findTripList = new ArrayList<>();

        //находим рейсы этих туров
        for( Tour tour :tourList){
            List<Trip> tripList = tripRepository.findTripByTour(tour.getId());

            for (Trip trip :tripList){
                //есть ли доступные рейсы по датам
                LocalDate start = trip.getStartDate().minusDays(1);
                if (start.isAfter(LocalDate.now())) {

                    //есть ли свободные билеты на рейс
                    List<Ticket> ticketList = ticketRepository.TicketsTrip(trip.getId());
                    Bus b = busRepository.findBusByTrip(trip.getId());
                    int freeSpace = b.getNumberSeats() - ticketList.size();

                    if (freeSpace != 0 && freeSpace>=numberPassengers) {

                        findTripList.add(trip);
                        break;
                    }
                }
            }

        }

        return findTripList.stream().map(trip -> modelMapper.map(trip, TripDTO.class)).toList();

    }










//    @Override
//    public List<TourDTO> getRecommendationsTour(PassengerDTO passengerDTO) {
//        Passenger passenger = modelMapper.map(passengerDTO, Passenger.class);
//        return tourRepository.findToursByPassengerId(passenger.getId()).stream().map((tour) -> modelMapper.map(tour,TourDTO.class)).toList();
//    }
//
//    @Override
//    public List<TourDTO> getTourForTourGroup(TourGroupDTO tourGroupDTO) {
//        TourGroup tourGroup = modelMapper.map(tourGroupDTO, TourGroup.class);
//       Integer countC = tourGroupRepository.countPassengersBefore18InTourGroup(tourGroup.getId());
//       Integer countP = tourGroupRepository.countPassengersUnder18InTourGroup(tourGroup.getId());
//
//        return tourRepository.findToursByTourGroup(countC, countP).stream().map((tour) -> modelMapper.map(tour, TourDTO.class)).toList();
//    }
}
