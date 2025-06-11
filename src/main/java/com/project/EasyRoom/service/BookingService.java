package com.project.EasyRoom.service;

import java.util.Date;
import java.util.List;

import com.project.EasyRoom.model.Booking;

public interface BookingService {

    void saveBooking(Booking booking);
    void deleteBookingById(int idBooking);
    Booking getBookingById(int idBooking);

    List<Booking> getBookingByUser(int idUser);
    List<Booking> getBookingByUserAndStatus(int idUser, int statusBill);
    List<Booking> getBookingByStatus(int statusBill);
    List<Booking> getBookingInTime(String dateStart, String dateEnd);
    List<Booking> getBookingWithRoomOwner(int idUser);
    List<Booking> getBookingWithRoomOwnerAndStatus(int idUser, int statusBill);
    List<Booking> getBookingOnTimeWithStatus(int statusBill, String dateStart, String dateEnd);

    void changeStatusBill(int statusBill, int idBooking);
    int countBookingByRoom(int idRoom);
    long countBooking();

    List<Booking> checkBookingConflict(int idRoom, String dateStart, String dateEnd);

    List<Booking> findBookingByRoomAndDateRange(int idRoom, Date dateStart, Date dateEnd);

    String[] getRevenueByDate(String dateStart, String dateEnd, int statusBill);

    String[] getRevenueByDateAndUser(String dateStart, String dateEnd, int statusBill, int idUser);
}
