package com.project.EasyRoom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.EasyRoom.model.Event;
import com.project.EasyRoom.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository repository;

    @Override
    public void saveEvent(Event entity) {
        repository.save(entity);
    }

    @Override
    public void deleteEventById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Event getEventById(int id) {
        Optional<Event> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    @Override
    public long countEvents() {
        return repository.count();
    }
}
