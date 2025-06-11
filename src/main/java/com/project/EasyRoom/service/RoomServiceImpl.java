package com.project.EasyRoom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.EasyRoom.model.Room;
import com.project.EasyRoom.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void saveRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void deleteRoomById(int idRoom) {
        roomRepository.deleteById(idRoom);
    }

    @Override
    public Room getRoomById(int idRoom) {
        Optional<Room> optional = roomRepository.findById(idRoom);
        return optional.orElse(null);
    }

    @Override
    public List<Room> getAllRoomsOrderByTitle() {
        return roomRepository.getAllRoomsOrderByTitleAsc();
    }

    @Override
    public List<Room> getRoomsByUser(int idUser) {
        return roomRepository.findRoomByUserIdUserOrderByTitleAsc(idUser);
    }

    @Override
    public List<Room> getRoomsByUserAndAvailability(int idUser, boolean isAvailable) {
        return roomRepository.findRoomByUserIdUserAndIsAvailableOrderByTitleAsc(idUser, isAvailable);
    }

    @Override
    public void updateRoomAvailability(boolean isAvailable, int idRoom) {
        roomRepository.updateRoomAvailability(isAvailable, idRoom);
    }

    @Override
    public int countRoomByAddress(String address) {
        return roomRepository.countByAddressRoomContaining(address);
    }

    @Override
    public int countRoomByAddressAndRentalType(String address, boolean rentalType) {
        return roomRepository.countByAddressRoomContainingAndRentalType(address, rentalType);
    }

    @Override
    public void updateAllPromotionalPrices(int promotionalPrice) {
        roomRepository.updateAllPromotionalPrices(promotionalPrice);
    }

    @Override
    public void updatePromotionalPriceById(int promotionalPrice, int idRoom) {
        roomRepository.updatePromotionalPriceById(promotionalPrice, idRoom);
    }

    @Override
    public List<Room> searchRoomByTitle(String keyword) {
        return roomRepository.findRoomByTitleContainingIgnoreCase(keyword);
    }

    @Override
    public List<Room> getPromotionalRoomsByAddress(String address) {
        return roomRepository.findRoomByAddressRoomContainingAndPromotionalPriceGreaterThan(address, 0);
    }

    @Override
    public List<Room> getRoomsWithWifi() {
        return roomRepository.findByHasWifiTrue();
    }

    @Override
    public List<Room> getRoomsWithAirConditioning() {
        return roomRepository.findByHasAirConditioningTrue();
    }

    @Override
    public List<Room> getRoomsWithParking() {
        return roomRepository.findByHasParkingTrue();
    }

    @Override
    public List<Room> getRoomsWithWashingMachine() {
        return roomRepository.findByHasWashingMachineTrue();
    }

    @Override
    public List<Room> getRoomsWithSecurityCamera() {
        return roomRepository.findByHasSecurityCameraTrue();
    }

    @Override
    public List<Room> getAirConditionedRoomsInAddress(String address) {
        return roomRepository.findByHasAirConditioningTrueAndAddressRoomContaining(address);
    }

    @Override
    public List<Room> getAvailableWifiParkingRoomsOrderByPrice() {
        return roomRepository.findByHasWifiTrueAndHasParkingTrueAndIsAvailableTrueOrderByPriceAsc();
    }

    @Override
    public List<Room> getAvailableRoomsInTimeRange(boolean rentalType, String address, String dateStart, String dateEnd, boolean isAvailable) {
        return roomRepository.findAvailableRoomsInTimeRange(rentalType, address, dateStart, dateEnd, isAvailable);
    }

    @Override
    public long countRooms() {
        return roomRepository.count();
    }
}
