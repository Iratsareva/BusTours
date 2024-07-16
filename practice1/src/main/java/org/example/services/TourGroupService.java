package org.example.services;

import org.example.domain.TourGroup;

public interface TourGroupService {
    void addTourGroup (TourGroup tourGroup);
    TourGroup getTourGroupById(int id);
}
