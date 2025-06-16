package com.project.EasyRoom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.EasyRoom.model.Room;
import com.project.EasyRoom.service.RoomService;

@RestController
@RequestMapping("/api")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public List<Room> getAll() {
        return roomService.getAllRoomsOrderByTitle();
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getById(@PathVariable int id) {
        Room room = roomService.getRoomById(id);
        if (room != null) {
            return ResponseEntity.ok(room);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/rooms")
    public Room create(@RequestBody Room room) {
        roomService.saveRoom(room);
        return room;
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> update(@PathVariable int id, @RequestBody Room room) {
        Room existing = roomService.getRoomById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        room.setIdRoom(id);
        roomService.saveRoom(room);
        return ResponseEntity.ok(room);
    }

    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        roomService.deleteRoomById(id);
        return ResponseEntity.noContent().build();
    }
}
