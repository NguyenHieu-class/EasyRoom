package com.project.EasyRoom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.EasyRoom.model.RoomType;
import com.project.EasyRoom.repository.RoomTypeRepository;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public RoomType getRoomTypeById(int id) {
        Optional<RoomType> optional = roomTypeRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }

    @Override
    public void deleteRoomType(int id) {
        roomTypeRepository.deleteById(id);
    }

    @Override
    public void saveRoomType(RoomType roomType) {
        roomTypeRepository.save(roomType);
    }

    @Override
    public boolean checkRoomTypeNameExist(List<RoomType> listRoomTypes, RoomType roomType) {
        for (RoomType rt : listRoomTypes) {
            if (rt.getNameType().trim().equalsIgnoreCase(roomType.getNameType().trim())
                && rt.getIdRoomType() != roomType.getIdRoomType()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<RoomType> getAllRoomTypesOrderByNameAsc() {
        return roomTypeRepository.getAllRoomTypeOrderByNameAsc();
    }
}
