package org.example.services;

import org.example.domain.TourGroup;
import org.example.dto.TourGroupDTO;

public interface TourGroupService {
    void addTourGroup (TourGroupDTO tourGroupDTO);
    TourGroupDTO getTourGroupById(int id);
}
