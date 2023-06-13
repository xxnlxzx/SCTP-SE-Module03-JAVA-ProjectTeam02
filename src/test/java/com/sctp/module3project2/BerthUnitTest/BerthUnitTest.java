package com.sctp.module3project2.BerthUnitTest;

import org.junit.jupiter.api.Test;

import com.sctp.module3project2.Berth.Berth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BerthTest {

    @Test
    void testGettersAndSetters() {
        // Create a sample berth
        Berth berth = new Berth();

        // Set values using setters
        berth.setId(1L);
        berth.setName("Berth 1");
        berth.setAvailability(true);

        // Verify values using getters
        assertEquals(1L, berth.getId());
        assertEquals("Berth 1", berth.getName());
        assertEquals(true, berth.isAvailability());
    }

    // Add more test methods as needed

    @Test
    void testDefaultConstructor() {
        // Create a sample berth using the default constructor
        Berth berth = new Berth();

        // Verify that the values are null or default
        assertNull(berth.getId());
        assertNull(berth.getName());
        assertEquals(false, berth.isAvailability());
    }

    @Test
    void testParameterizedConstructor() {
        // Create a sample berth using the parameterized constructor
        Berth berth = new Berth("Berth 1");

        // Verify that the values are set correctly
        assertNull(berth.getId());
        assertEquals("Berth 1", berth.getName());
        assertEquals(false, berth.isAvailability());
    }

    // Add more test methods as needed
}
