package com.sctp.module3project2.BerthUnitTest;

import com.sctp.module3project2.dto.BerthDto;
import com.sctp.module3project2.entities.Berth;
import com.sctp.module3project2.repositories.BerthRepo;
import com.sctp.module3project2.services.BerthSvc;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class BerthSvcTest {

    @Mock
    private BerthRepo repository;

    @InjectMocks
    private BerthSvc service;

    public BerthSvcTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllBerthPortLocations() {
        // Create sample berths
        Berth berth1 = new Berth("Berth 1");
        Berth berth2 = new Berth("Berth 2");
        List<Berth> berths = Arrays.asList(berth1, berth2);

        // Mock the repository's findAll method
        when(repository.findAll()).thenReturn(berths);

        // Call the service method
        List<Berth> result = service.getAllBerthPortLocations();

        // Verify the result
        assertEquals(2, result.size());
        assertEquals("Berth 1", result.get(0).getName());
        assertEquals("Berth 2", result.get(1).getName());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testCreateBerthPortLocation() {
        // Create a sample berth
        Berth berth = new Berth("Berth 1");

        // Mock the repository's save method
        when(repository.save(berth)).thenReturn(berth);

        // Call the service method
        Berth result = service.createBerthPortLocation(berth);

        // Verify the result
        assertEquals("Berth 1", result.getName());
        verify(repository, times(1)).save(berth);
    }

    // Add more test methods for other service methods

    @Test
    void testGetAllBerthPortLocationsWithAvailability() {
        // Create sample berths
        Berth berth1 = new Berth("Berth 1");
        Berth berth2 = new Berth("Berth 2");
        List<Berth> berths = Arrays.asList(berth1, berth2);

        // Mock the repository's findAll method
        when(repository.findAll()).thenReturn(berths);

        // Call the service method
        List<BerthDto> result = service.getAllBerthPortLocationsWithAvailability();

        // Verify the result
        assertEquals(2, result.size());
        assertEquals("Berth 1", result.get(0).getName());
        assertEquals("Berth 2", result.get(1).getName());
        assertEquals(Arrays.asList("Tanjong Pagar", "Keppel", "Brani", "Pasir Panjang", "Sembawang", "Jurong", "Tuas"),
                result.get(0).getLocations());
        verify(repository, times(1)).findAll();
    }

    // Add more test methods as needed
}
