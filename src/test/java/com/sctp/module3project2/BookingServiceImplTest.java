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

import com.sctp.module3project2.entity.Berth;
import com.sctp.module3project2.entity.Booking;
import com.sctp.module3project2.entity.BookingDateTime;
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
        BookingDateTime bookingDateTime = new BookingDateTime((long) 1, "2023-04-01", "12:00");

        Berth berth = new Berth((long)1, "berth1", "east", true);

        Booking booking = new Booking((long)1, bookingDateTime, berth,  "activity", "remarks");

        when(bookingRepository.save(booking)).thenReturn(booking);

        Booking savedBooking = bookingService.saveBooking(booking);

        verify(bookingRepository, times(1)).save(booking);
        assertEquals(booking, savedBooking);
    }

    @Test
    public void getBookingTest() {
        BookingDateTime bookingDateTime = new BookingDateTime((long) 1, "2023-04-01", "12:00");

        Berth berth = new Berth((long)1, "berth1", "east", true);
        
        Booking booking = new Booking((long)1, bookingDateTime, berth,  "activity", "remarks");
        booking.setId((long) 1);

        when(bookingRepository.findById((long) 1)).thenReturn(Optional.of(booking));

        Booking foundBooking = bookingService.getBooking((long) 1);

        verify(bookingRepository, times(1)).findById((long) 1);
        assertEquals(booking, foundBooking);
    }

    @Test
    public void getAllBookingsTest() {
        BookingDateTime bookingDateTime = new BookingDateTime((long) 1, "2023-04-01", "12:00");

        Berth berth = new Berth((long)1, "berth1", "east", true);

        Booking booking = new Booking((long)1, bookingDateTime, berth,  "activity", "remarks");
        

        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking);

        when(bookingRepository.findAll()).thenReturn(bookings);

       ArrayList<Booking> allBookings = bookingService.getAllBookings();

        verify(bookingRepository, times(1)).findAll();
        assertEquals(1, allBookings.size());
    }
}
        
