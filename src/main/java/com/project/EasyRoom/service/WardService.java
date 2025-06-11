package com.project.EasyRoom.service;

import java.util.List;
import com.project.EasyRoom.model.Ward;

public interface WardService {

    void saveWard(Ward entity);
    void deleteWardById(int id);
    Ward getWardById(int id);
    List<Ward> getAllWards();
    long countWards();
}
