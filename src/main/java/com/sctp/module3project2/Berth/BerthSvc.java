package com.sctp.module3project2.Berth;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BerthSvc {
    private final BerthRepo repository;

    public BerthSvc(BerthRepo repository) {
        this.repository = repository;
    }

    public List<Berth> getAllBerthPortLocations() {
        return repository.findAll();
    }

    public Berth createBerthPortLocation(BerthDto berthDto) {
        Berth berth = new Berth();
        berth.setName(berthDto.getName());
        berth.setLocation(berthDto.getLocation());
        berth.setAvailability(true); // Assuming availability is always set to true for new berths.
        return repository.save(berth);
    }

    public Berth getBerthPortLocationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Berth updateBerthPortLocation(Long id, Berth updatedBerth) {
        Berth berth = repository.findById(id).orElse(null);
        if (berth != null) {
            berth.setName(updatedBerth.getName());
            return repository.save(berth);
        }
        return null;
    }

    public boolean deleteBerthPortLocation(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<BerthDto> getAllBerthPortLocationsWithAvailability() {
        List<Berth> berths = repository.findAll();
        List<BerthDto> berthDtos = new ArrayList<>();

        for (Berth berth : berths) {
            BerthDto berthDto = new BerthDto();
            berthDto.setId(berth.getId());
            berthDto.setName(berth.getName());
            berthDto.setAvailability(berth.isAvailability());
            berthDtos.add(berthDto);
        }

        return berthDtos;
    }
}
