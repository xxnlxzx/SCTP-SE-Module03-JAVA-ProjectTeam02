package com.sctp.module3project2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.sctp.module3project2.entity.Booking;
import com.sctp.module3project2.repository.BookingRepository;
import com.sctp.module3project2.services.BookingServiceImpl;

// Joel

@SpringBootTest
public class BookingServiceImplTest {
    
    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Test
    public void createBookingTest() {
        Booking booking = new Booking();

        when(bookingRepository.save(booking)).thenReturn(booking);

        Booking savedBooking = bookingService.saveBooking(booking);

        verify(bookingRepository, times(1)).save(booking);
        assertEquals(booking, savedBooking);
    }

    @Test
    public void getBookingTest() {
        Booking booking = new Booking();
        booking.setId(1);

        when(bookingRepository.findById(1)).thenReturn(Optional.of(booking));

        Booking foundBooking = bookingService.getBooking(1);

        verify(bookingRepository, times(1)).findById(1);
        assertEquals(booking, foundBooking);
    }

    @Test
    public void getAllBookingsTest() {
        Booking booking1 = new Booking();
        Booking booking2 = new Booking();

        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking1);
        bookings.add(booking2);

        when(bookingRepository.findAll()).thenReturn(bookings);

       ArrayList<Booking> allBookings = bookingService.getAllBookings();

        verify(bookingRepository, times(1)).findAll();
        assertEquals(2, allBookings.size());
    }
}
        
