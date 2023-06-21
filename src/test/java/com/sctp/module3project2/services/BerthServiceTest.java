package com.sctp.module3project2.services;

import com.sctp.module3project2.entity.Berth;
import com.sctp.module3project2.repository.BerthRepository;
// import com.sctp.module3project2.services.BerthServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BerthServiceTest {

    @Mock
    private BerthRepository berthRepository;

    @InjectMocks
    private BerthServiceImpl berthService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllBerths() {
        // Arrange
        List<Berth> berths = new ArrayList<>();
        berths.add(new Berth(1L, "Berth 1", "Location 1", true));
        berths.add(new Berth(2L, "Berth 2", "Location 2", true));

        when(berthRepository.findAll()).thenReturn(berths);

        // Act
        List<Berth> result = berthService.getAllBerths();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Berth 1", result.get(0).getName());
        assertEquals("Location 2", result.get(1).getLocation());
        verify(berthRepository, times(1)).findAll();
        verifyNoMoreInteractions(berthRepository);
    }

    @Test
    void getBerthById() {
        // Arrange
        Berth berth = new Berth(1L, "Berth 1", "Location 1", true);
        when(berthRepository.findById(1L)).thenReturn(Optional.of(berth));

        // Act
        Berth result = berthService.getBerthById(1L);

        // Assert
        assertEquals("Berth 1", result.getName());
        assertEquals("Location 1", result.getLocation());
        assertEquals(true, result.isAvailability());
        verify(berthRepository, times(1)).findById(1L);
        verifyNoMoreInteractions(berthRepository);
    }

    @Test
    void createBerth() {
        // Arrange
        Berth berth = new Berth(null, "New Berth", "New Location", true);
        Berth savedBerth = new Berth(1L, "New Berth", "New Location", true);
        when(berthRepository.save(berth)).thenReturn(savedBerth);

        // Act
        Berth result = berthService.createBerth(berth);

        // Assert
        assertEquals(1L, result.getId());
        assertEquals("New Berth", result.getName());
        assertEquals("New Location", result.getLocation());
        assertEquals(true, result.isAvailability());
        verify(berthRepository, times(1)).save(berth);
        verifyNoMoreInteractions(berthRepository);
    }

    @Test
    void updateBerth() {
        // Arrange
        Berth berth = new Berth(1L, "Berth 1", "Location 1", true);
        Berth updatedBerth = new Berth(1L, "Updated Berth", "Updated Location", false);
        when(berthRepository.findById(1L)).thenReturn(Optional.of(berth));
        when(berthRepository.save(berth)).thenReturn(updatedBerth);

        // Act
        Berth result = berthService.updateBerth(1L, updatedBerth);

        // Assert
        assertEquals("Updated Berth", result.getName());
        assertEquals("Updated Location", result.getLocation());
        assertEquals(false, result.isAvailability());
        verify(berthRepository, times(1)).findById(1L);
        verify(berthRepository, times(1)).save(berth);
        verifyNoMoreInteractions(berthRepository);
    }

    @Test
    void deleteBerth() {
        // Arrange
        Berth berth = new Berth(1L, "Berth Name", "Berth Location", true);
        when(berthRepository.findById(1L)).thenReturn(Optional.of(berth));

        // Act
        berthService.deleteBerth(1L);

        // Assert
        verify(berthRepository, times(1)).findById(1L);
        verify(berthRepository, times(1)).deleteById(1L);
        verifyNoMoreInteractions(berthRepository);
    }

    @Test
    void deleteAllBerths() {
        // Arrange & Act
        berthService.deleteAllBerths();

        // Assert
        verify(berthRepository, times(1)).deleteAll();
        verifyNoMoreInteractions(berthRepository);
    }

    @Test
    void resetBerthIdSequence() {
        // Arrange & Act
        berthService.resetBerthIdSequence();

        // Assert
        verify(berthRepository, times(1)).resetIdSequence();
        verifyNoMoreInteractions(berthRepository);
    }
}
