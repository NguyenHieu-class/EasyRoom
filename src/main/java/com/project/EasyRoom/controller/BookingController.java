package com.project.EasyRoom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.EasyRoom.model.Booking;
import com.project.EasyRoom.service.BookingService;

@RestController
@RequestMapping("/api")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings")
    public List<Booking> getAll() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/bookings/{id}")
    public ResponseEntity<Booking> getById(@PathVariable int id) {
        Booking booking = bookingService.getBookingById(id);
        if (booking != null) {
            return ResponseEntity.ok(booking);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/bookings")
    public Booking create(@RequestBody Booking booking) {
        bookingService.saveBooking(booking);
        return booking;
    }

    @PutMapping("/bookings/{id}")
    public ResponseEntity<Booking> update(@PathVariable int id, @RequestBody Booking booking) {
        Booking existing = bookingService.getBookingById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        booking.setIdBooking(id);
        bookingService.saveBooking(booking);
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/bookings/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        bookingService.deleteBookingById(id);
        return ResponseEntity.noContent().build();
    }
}
