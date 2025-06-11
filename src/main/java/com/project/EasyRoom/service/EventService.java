package com.project.EasyRoom.service;

import java.util.List;
import com.project.EasyRoom.model.Event;

public interface EventService {

    void saveEvent(Event entity);
    void deleteEventById(int id);
    Event getEventById(int id);
    List<Event> getAllEvents();
    long countEvents();
}
