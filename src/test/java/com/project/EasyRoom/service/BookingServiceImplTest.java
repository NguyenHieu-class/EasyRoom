package com.project.EasyRoom.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import com.project.EasyRoom.model.Booking;
import com.project.EasyRoom.repository.BookingRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookingServiceImplTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Test
    void testGetBookingOnTimeWithStatusCallsRepository() {
        List<Booking> expected = Collections.emptyList();
        when(bookingRepository.getBookingOnTimeWithStatus(1, "2024-01-01", "2024-01-10"))
            .thenReturn(expected);

        List<Booking> result = bookingService.getBookingOnTimeWithStatus(1, "2024-01-01", "2024-01-10");

        assertSame(expected, result);
        verify(bookingRepository).getBookingOnTimeWithStatus(1, "2024-01-01", "2024-01-10");
    }
}
