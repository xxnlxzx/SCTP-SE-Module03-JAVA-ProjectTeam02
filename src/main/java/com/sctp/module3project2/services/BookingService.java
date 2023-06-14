package com.sctp.module3project2.services;

import java.util.ArrayList;
import com.sctp.module3project2.entity.Booking;


// Joel 


public interface BookingService {
    
    Booking saveBooking(Booking booking);

    Booking getBooking(int id);

    ArrayList<Booking> getAllBookings();

    Booking updateBooking(int id, Booking booking);

    void deleteBooking(int id);
}
