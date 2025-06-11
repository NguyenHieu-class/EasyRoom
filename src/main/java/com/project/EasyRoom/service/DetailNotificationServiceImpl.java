package com.project.EasyRoom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.EasyRoom.model.DetailNotification;
import com.project.EasyRoom.repository.DetailNotificationRepository;

@Service
public class DetailNotificationServiceImpl implements DetailNotificationService {

    @Autowired
    private DetailNotificationRepository repository;

    @Override
    public void saveDetailNotification(DetailNotification entity) {
        repository.save(entity);
    }

    @Override
    public void deleteDetailNotificationById(int id) {
        repository.deleteById(id);
    }

    @Override
    public DetailNotification getDetailNotificationById(int id) {
        Optional<DetailNotification> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<DetailNotification> getAllDetailNotifications() {
        return repository.findAll();
    }

    @Override
    public long countDetailNotifications() {
        return repository.count();
    }
}
