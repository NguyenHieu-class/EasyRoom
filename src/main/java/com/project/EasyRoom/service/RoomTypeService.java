package com.project.EasyRoom.service;

import java.util.List;

import com.project.EasyRoom.model.RoomType;

public interface RoomTypeService {

    RoomType getRoomTypeById(int id);
    List<RoomType> getAllRoomTypes();
    void deleteRoomType(int id);
    void saveRoomType(RoomType roomType);
    boolean checkRoomTypeNameExist(List<RoomType> listRoomTypes, RoomType roomType);
    List<RoomType> getAllRoomTypesOrderByNameAsc();
}
