package com.project.EasyRoom.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.EasyRoom.model.Booking;
import com.project.EasyRoom.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void saveBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public void deleteBookingById(int idBooking) {
        bookingRepository.deleteById(idBooking);
    }

    @Override
    public Booking getBookingById(int idBooking) {
        Optional<Booking> optional = bookingRepository.findById(idBooking);
        return optional.orElse(null);
    }

    @Override
    public List<Booking> getBookingByUser(int idUser) {
        return bookingRepository.findBookingByUserIdUserOrderByDateStartDesc(idUser);
    }

    @Override
    public List<Booking> getBookingByUserAndStatus(int idUser, int statusBill) {
        return bookingRepository.findBookingByUserIdUserAndStatusBillOrderByDateStartDesc(idUser, statusBill);
    }

    @Override
    public List<Booking> getBookingByStatus(int statusBill) {
        return bookingRepository.findBookingByStatusBill(statusBill);
    }

    @Override
    public void changeStatusBill(int statusBill, int idBooking) {
        bookingRepository.changeStatusBill(statusBill, idBooking);
    }

    @Override
    public int countBookingByRoom(int idRoom) {
        return bookingRepository.countByRoomIdRoom(idRoom);
    }

    @Override
    public long countBooking() {
        return bookingRepository.count();
    }

    @Override
    public List<Booking> checkBookingConflict(int idRoom, String dateStart, String dateEnd) {
        return bookingRepository.checkBookingExistOnTime(idRoom, dateStart, dateEnd);
    }

    @Override
    public List<Booking> findBookingByRoomAndDateRange(int idRoom, Date dateStart, Date dateEnd) {
        return bookingRepository.findBookingByRoomIdRoomAndDateStartGreaterThanEqualAndDateEndLessThanEqual(
            idRoom, dateStart, dateEnd);
    }

    @Override
    public List<Booking> getBookingInTime(String dateStart, String dateEnd) {
        return bookingRepository.getAllBookingOnTime(dateStart, dateEnd);
    }

    @Override
    public List<Booking> getBookingWithRoomOwner(int idUser) {
        return bookingRepository.getAllBookingWithRoomOwner(idUser);
    }

    @Override
    public List<Booking> getBookingWithRoomOwnerAndStatus(int idUser, int statusBill) {
        return bookingRepository.getAllBookingWithRoomOwnerAndStatusBill(idUser, statusBill);
    }

    @Override
    public List<Booking> getBookingOnTimeWithStatus(int statusBill, String dateStart, String dateEnd) {
        return bookingRepository.getBookingOnTimeWithStatus(statusBill, dateStart, dateEnd);
    }

    @Override
    public String[] getRevenueByDate(String dateStart, String dateEnd, int statusBill) {
        return bookingRepository.sumRevenueOnTime(dateStart, dateEnd, statusBill);
    }

    @Override
    public String[] getRevenueByDateAndUser(String dateStart, String dateEnd, int statusBill, int idUser) {
        return bookingRepository.sumRevenueOnTimeByIdUser(dateStart, dateEnd, statusBill, idUser);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
