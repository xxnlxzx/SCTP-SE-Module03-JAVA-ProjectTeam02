package com.sctp.module3project2.repository;

import com.sctp.module3project2.entity.Booking;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// @Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
  
}
