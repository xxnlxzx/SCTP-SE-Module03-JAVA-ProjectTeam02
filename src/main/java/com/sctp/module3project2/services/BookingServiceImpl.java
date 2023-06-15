package com.sctp.module3project2.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.sctp.module3project2.entity.Booking;
import com.sctp.module3project2.exception.BookingNotFoundException;
import com.sctp.module3project2.repository.BookingRepository;

// Joel

@Service
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    
    @Override
    public Booking saveBooking(Booking booking) {
        Booking newBooking = bookingRepository.save(booking);
        return newBooking;
    }

    @Override
    public Booking getBooking(int id) {
        Optional<Booking> foundBooking = bookingRepository.findById(id);
        if (!foundBooking.isPresent()){
            throw new BookingNotFoundException("Booking not found");
        }
        return foundBooking.get();
        
    }

    @Override
    public ArrayList<Booking> getAllBookings() {
        ArrayList<Booking> allBookings = (ArrayList<Booking>) bookingRepository.findAll();
        return allBookings;
    }

    @Override
    public Booking updateBooking(int id, Booking booking) {
        Optional<Booking> foundBooking = bookingRepository.findById(id);
        if (!foundBooking.isPresent()){
            throw new BookingNotFoundException("Booking not found");
        }
        // fill in when other fields are added
        Booking bookingToUpdate = foundBooking.get();

        bookingToUpdate.setRemarks(booking.getRemarks());
        bookingToUpdate.setActivity(booking.getActivity());
        // bookingToUpdate.setCreated_at(booking.getCreated_at());

        return bookingRepository.save(bookingToUpdate);
    }

    @Override
    public void deleteBooking(int id) {
        bookingRepository.deleteById(id);
    }


 
}
