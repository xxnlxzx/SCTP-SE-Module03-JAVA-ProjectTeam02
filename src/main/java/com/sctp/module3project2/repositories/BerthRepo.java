package com.sctp.module3project2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

import com.sctp.module3project2.entities.Berth;

// @Repository
public interface BerthRepo extends JpaRepository<Berth, Long> {
}
