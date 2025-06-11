package com.project.EasyRoom.service;

import java.util.List;
import com.project.EasyRoom.model.GuideToWork;

public interface GuideToWorkService {

    void saveGuideToWork(GuideToWork entity);
    void deleteGuideToWorkById(int id);
    GuideToWork getGuideToWorkById(int id);
    List<GuideToWork> getAllGuideToWorks();
    long countGuideToWorks();
}
