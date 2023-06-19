package com.sctp.module3project2.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sctp.module3project2.entity.Berth;
import com.sctp.module3project2.entity.Booking;
import com.sctp.module3project2.entity.BookingDateTime;
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
    public Booking getBooking(Long id) {
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
    public Booking updateBooking(Long id, Booking booking) {
        Optional<Booking> foundBooking = bookingRepository.findById(id);
        if (!foundBooking.isPresent()){
            throw new BookingNotFoundException("Booking not found");
        }
        // fill in when other fields are added
        Booking bookingToUpdate = foundBooking.get();

        bookingToUpdate.setRemarks(booking.getRemarks());
        bookingToUpdate.setActivity(booking.getActivity());
        
      
        // // bookingToUpdate.setCreated_at(booking.getCreated_at());
        BookingDateTime datetimeInfo = booking.getBookingDateTime();

        BookingDateTime datetime = new BookingDateTime(); 
        datetime.setBookdate(datetimeInfo.getBookdate());
        datetime.setBooktime(datetimeInfo.getBooktime());
        // bookingToUpdate.setBookingDateTime(booking.getBookingDateTime());
        bookingToUpdate.getBookingDateTime().setBookdate(datetime.getBookdate());      
        bookingToUpdate.getBookingDateTime().setBooktime(datetime.getBooktime());

        Berth berthInfo = booking.getBerth();

        Berth berth = new Berth();
        berth.setName(berthInfo.getName());
        berth.setLocation(berthInfo.getLocation());
        berth.setAvailability(berthInfo.isAvailability());
        // bookingToUpdate.setBerth(booking.getBerth());

        bookingToUpdate.getBerth().setName(berth.getName());
        bookingToUpdate.getBerth().setLocation(berth.getLocation());
        bookingToUpdate.getBerth().setAvailability(berth.isAvailability());

        return bookingRepository.save(bookingToUpdate);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }


 
}
