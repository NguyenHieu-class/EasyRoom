package com.project.EasyRoom.service;

import java.util.List;

import com.project.EasyRoom.model.Room;

public interface RoomService {

    void saveRoom(Room room);

    void deleteRoomById(int idRoom);

    Room getRoomById(int idRoom);

    List<Room> getAllRoomsOrderByTitle();

    List<Room> getRoomsByUser(int idUser);

    List<Room> getRoomsByUserAndAvailability(int idUser, boolean isAvailable);

    void updateRoomAvailability(boolean isAvailable, int idRoom);

    int countRoomByAddress(String address);

    int countRoomByAddressAndRentalType(String address, boolean rentalType);

    void updateAllPromotionalPrices(int promotionalPrice);

    void updatePromotionalPriceById(int promotionalPrice, int idRoom);

    List<Room> searchRoomByTitle(String keyword);

    List<Room> getPromotionalRoomsByAddress(String address);

    List<Room> getRoomsWithWifi();

    List<Room> getRoomsWithAirConditioning();

    List<Room> getRoomsWithParking();

    List<Room> getRoomsWithWashingMachine();

    List<Room> getRoomsWithSecurityCamera();

    List<Room> getAirConditionedRoomsInAddress(String address);

    List<Room> getAvailableWifiParkingRoomsOrderByPrice();

    List<Room> getAvailableRoomsInTimeRange(boolean rentalType, String address, String dateStart, String dateEnd, boolean isAvailable);

    long countRooms();
}
