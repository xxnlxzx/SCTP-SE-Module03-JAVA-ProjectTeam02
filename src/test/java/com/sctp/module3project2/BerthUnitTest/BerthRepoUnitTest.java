package com.sctp.module3project2.BerthUnitTest;

import com.sctp.module3project2.Berth.Berth;
import com.sctp.module3project2.Berth.BerthRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BerthRepoTest {

    @Autowired
    private BerthRepo berthRepo;

    @Test
    void testSaveBerth() {
        // Create a new berth
        Berth berth = new Berth("Berth 1");

        // Save the berth to the repository
        Berth savedBerth = berthRepo.save(berth);

        // Verify the saved berth
        assertEquals("Berth 1", savedBerth.getName());
        assertTrue(savedBerth.getId() > 0);
    }

    @Test
    void testFindAllBerths() {
        // Create some sample berths
        Berth berth1 = new Berth("Berth 1");
        Berth berth2 = new Berth("Berth 2");

        // Save the berths to the repository
        berthRepo.save(berth1);
        berthRepo.save(berth2);

        // Retrieve all berths from the repository
        List<Berth> berths = berthRepo.findAll();

        // Verify the number of retrieved berths
        assertEquals(2, berths.size());
    }

    // Add more test methods as needed
}
