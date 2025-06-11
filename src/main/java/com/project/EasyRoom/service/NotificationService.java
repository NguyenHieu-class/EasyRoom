package com.project.EasyRoom.service;

import java.util.List;
import com.project.EasyRoom.model.Notification;

public interface NotificationService {

    void saveNotification(Notification entity);
    void deleteNotificationById(int id);
    Notification getNotificationById(int id);
    List<Notification> getAllNotifications();
    long countNotifications();
}
