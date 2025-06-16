package com.project.EasyRoom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.EasyRoom.model.RoomType;
import com.project.EasyRoom.service.RoomTypeService;

@RestController
@RequestMapping("/api")
public class RoomTypeController {

    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping("/room-types")
    public List<RoomType> getAll() {
        return roomTypeService.getAllRoomTypes();
    }

    @GetMapping("/room-types/{id}")
    public ResponseEntity<RoomType> getById(@PathVariable int id) {
        RoomType roomType = roomTypeService.getRoomTypeById(id);
        if (roomType != null) {
            return ResponseEntity.ok(roomType);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/room-types")
    public RoomType create(@RequestBody RoomType roomType) {
        roomTypeService.saveRoomType(roomType);
        return roomType;
    }

    @PutMapping("/room-types/{id}")
    public ResponseEntity<RoomType> update(@PathVariable int id, @RequestBody RoomType roomType) {
        RoomType existing = roomTypeService.getRoomTypeById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        roomType.setIdRoomType(id);
        roomTypeService.saveRoomType(roomType);
        return ResponseEntity.ok(roomType);
    }

    @DeleteMapping("/room-types/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        roomTypeService.deleteRoomType(id);
        return ResponseEntity.noContent().build();
    }
}
