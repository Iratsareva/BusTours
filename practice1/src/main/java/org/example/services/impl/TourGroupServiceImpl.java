package org.example.services.impl;

import org.example.domain.TourGroup;
import org.example.repositories.TourGroupRepository;
import org.example.services.TourGroupService;

public class TourGroupServiceImpl implements TourGroupService {

    private TourGroupRepository tourGroupRepository;

    @Override
    public void addTourGroup(TourGroup tourGroup) {
        tourGroupRepository.create(tourGroup);
    }

    @Override
    public TourGroup getTourGroupById(int id) {
        return tourGroupRepository.findById(TourGroup.class, id);
    }
}
