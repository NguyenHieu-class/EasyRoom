package com.project.EasyRoom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.EasyRoom.model.Event;
import com.project.EasyRoom.service.EventService;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public List<Event> getAll() {
        return eventService.getAllEvents();
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getById(@PathVariable int id) {
        Event event = eventService.getEventById(id);
        if (event != null) {
            return ResponseEntity.ok(event);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/events")
    public Event create(@RequestBody Event event) {
        eventService.saveEvent(event);
        return event;
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<Event> update(@PathVariable int id, @RequestBody Event event) {
        Event existing = eventService.getEventById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        event.setIdEvent(id);
        eventService.saveEvent(event);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        eventService.deleteEventById(id);
        return ResponseEntity.noContent().build();
    }
}
