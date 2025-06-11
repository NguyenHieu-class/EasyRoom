package com.project.EasyRoom.service;

import java.util.List;
import com.project.EasyRoom.model.DetailNotification;

public interface DetailNotificationService {

    void saveDetailNotification(DetailNotification entity);
    void deleteDetailNotificationById(int id);
    DetailNotification getDetailNotificationById(int id);
    List<DetailNotification> getAllDetailNotifications();
    long countDetailNotifications();
}
