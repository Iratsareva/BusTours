package org.example.services.impl;

import org.example.domain.TourGroup;
import org.example.dto.TourGroupDTO;
import org.example.repositories.TourGroupRepository;
import org.example.services.TourGroupService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourGroupServiceImpl implements TourGroupService {


    @Autowired
    private TourGroupRepository tourGroupRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public void addTourGroup(TourGroupDTO tourGroupDTO) {
        TourGroup tourGroup = modelMapper.map(tourGroupDTO, TourGroup.class);
        tourGroupRepository.create(tourGroup);
    }

    @Override
    public TourGroupDTO getTourGroupById(int id) {
        TourGroup tg = tourGroupRepository.findById(TourGroup.class, id);
        return modelMapper.map(tg, TourGroupDTO.class);
    }
}
