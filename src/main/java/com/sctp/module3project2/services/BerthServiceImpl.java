package com.sctp.module3project2.services;

import com.sctp.module3project2.entity.Berth;
import com.sctp.module3project2.repository.BerthRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BerthServiceImpl implements BerthService {

    private final BerthRepository berthRepository;

    @Autowired
    public BerthServiceImpl(BerthRepository berthRepository) {
        this.berthRepository = berthRepository;
    }

    @Override
    public Berth createBerth(Berth berth) {
        return berthRepository.save(berth);
    }

    @Override
    public List<Berth> getAllBerths() {
        return berthRepository.findAll();
    }

    @Override
    public Berth getBerthById(Long id) {
        Optional<Berth> optionalBerth = berthRepository.findById(id);
        return optionalBerth.orElse(null);
    }

    @Override
    public Berth saveBerth(Berth berth) {
        return berthRepository.save(berth);
    }

    @Override
    public Berth updateBerth(Long id, Berth berth) {
        Optional<Berth> optionalBerth = berthRepository.findById(id);
        if (optionalBerth.isPresent()) {
            Berth existingBerth = optionalBerth.get();
            existingBerth.setName(berth.getName());
            existingBerth.setLocation(berth.getLocation());
            existingBerth.setAvailability(berth.isAvailability());
            return berthRepository.save(existingBerth);
        }
        return null;
    }

    @Override
    public void deleteBerth(Long id) {
        berthRepository.deleteById(id);
    }

}
