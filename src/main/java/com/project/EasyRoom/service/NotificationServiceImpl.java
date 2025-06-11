package com.project.EasyRoom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.EasyRoom.model.Notification;
import com.project.EasyRoom.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository repository;

    @Override
    public void saveNotification(Notification entity) {
        repository.save(entity);
    }

    @Override
    public void deleteNotificationById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Notification getNotificationById(int id) {
        Optional<Notification> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Notification> getAllNotifications() {
        return repository.findAll();
    }

    @Override
    public long countNotifications() {
        return repository.count();
    }
}
