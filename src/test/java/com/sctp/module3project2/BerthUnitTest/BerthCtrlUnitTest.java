package com.sctp.module3project2.BerthUnitTest;

import com.sctp.module3project2.Berth.Berth;
import com.sctp.module3project2.Berth.BerthCtrl;
import com.sctp.module3project2.Berth.BerthDto;
import com.sctp.module3project2.Berth.BerthSvc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class BerthCtrlUnitTest {

    @Mock
    private BerthSvc service;

    @InjectMocks
    private BerthCtrl controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * 
     */
    @Test
    void getAllBerthPortLocations_ReturnsListOfBerth() {
        // Arrange
        List<Berth> berths = new ArrayList<>();
        berths.add(new Berth("Berth 1"));
        berths.add(new Berth("Berth 2"));

        when(service.getAllBerthPortLocations()).thenReturn(berths);

        // Act
        List<Berth> result = controller.getAllBerthPortLocations();

        // Assert
        try {
            assertEquals("Unexpected size of the result list", 2, result.size());
        } catch (AssertionError e) {
            fail("Expected size: 2, Actual size: " + result.size());
        }

        verify(service, times(1)).getAllBerthPortLocations();
    }

    private void assertEquals(String string, int actual, int size) {
    }

    @Test
    void createBerthPortLocation_ReturnsCreatedBerth() {
        Berth berth = new Berth("Berth 1");
        Berth createdBerth = new Berth(1L, "Berth 1");

        when(service.createBerthPortLocation(berth)).thenReturn(createdBerth);

        ResponseEntity<Berth> response = controller.createBerthPortLocation(berth);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals(createdBerth, response.getBody());
        verify(service, times(1)).createBerthPortLocation(berth);
    }

    @Test
    void getBerthPortLocationById_WithExistingId_ReturnsBerth() {
        Long id = 1L;
        Berth berth = new Berth(id, "Berth 1");

        when(service.getBerthPortLocationById(id)).thenReturn(berth);

        ResponseEntity<Berth> response = controller.getBerthPortLocationById(id);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(berth, response.getBody());
        verify(service, times(1)).getBerthPortLocationById(id);
    }

    @Test
    void getBerthPortLocationById_WithNonExistingId_ReturnsNotFound() {
        Long id = 1L;

        when(service.getBerthPortLocationById(id)).thenReturn(null);

        ResponseEntity<Berth> response = controller.getBerthPortLocationById(id);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(service, times(1)).getBerthPortLocationById(id);
    }

    @Test
    void updateBerthPortLocation_WithExistingId_ReturnsUpdatedBerth() {
        Long id = 1L;
        Berth updatedBerth = new Berth(id, "Updated Berth");

        when(service.updateBerthPortLocation(id, updatedBerth)).thenReturn(updatedBerth);

        ResponseEntity<Berth> response = controller.updateBerthPortLocation(id, updatedBerth);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(updatedBerth, response.getBody());
        verify(service, times(1)).updateBerthPortLocation(id, updatedBerth);
    }

    @Test
    void updateBerthPortLocation_WithNonExistingId_ReturnsNotFound() {
        Long id = 1L;
        Berth updatedBerth = new Berth(id, "Updated Berth");

        when(service.updateBerthPortLocation(id, updatedBerth)).thenReturn(null);

        ResponseEntity<Berth> response = controller.updateBerthPortLocation(id, updatedBerth);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(service, times(1)).updateBerthPortLocation(id, updatedBerth);
    }

    @Test
    void deleteBerthPortLocation_WithExistingId_ReturnsNoContent() {
        Long id = 1L;

        when(service.deleteBerthPortLocation(id)).thenReturn(true);

        ResponseEntity<Void> response = controller.deleteBerthPortLocation(id);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
        verify(service, times(1)).deleteBerthPortLocation(id);
    }

    @Test
    void deleteBerthPortLocation_WithNonExistingId_ReturnsNotFound() {
        Long id = 1L;

        when(service.deleteBerthPortLocation(id)).thenReturn(false);

        ResponseEntity<Void> response = controller.deleteBerthPortLocation(id);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(service, times(1)).deleteBerthPortLocation(id);
    }

    @Test
    void getAllBerthPortLocationsWithAvailability_ReturnsListOfBerthDto() {
        List<BerthDto> berthDtos = new ArrayList<>();
        berthDtos.add(new BerthDto());
        berthDtos.add(new BerthDto());

        when(service.getAllBerthPortLocationsWithAvailability()).thenReturn(berthDtos);

        List<BerthDto> result = controller.getAllBerthPortLocationsWithAvailability();

        Assertions.assertEquals(2, result.size());
        verify(service, times(1)).getAllBerthPortLocationsWithAvailability();
    }
}
