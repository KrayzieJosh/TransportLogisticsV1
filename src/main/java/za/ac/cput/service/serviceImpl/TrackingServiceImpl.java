package za.ac.cput.service.serviceImpl;

/* LocationServiceImpl.java
 Entities for the serviceImpl
 Author: Joshua Jacobs (221144862)
 Date: 9 June 2023
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Tracking;
import za.ac.cput.repository.TrackingRepository;
import za.ac.cput.service.TrackingService;

import java.util.Set;


@Service
public class TrackingServiceImpl implements TrackingService {

    private TrackingRepository repository;
    @Autowired
    private TrackingServiceImpl(TrackingRepository repository) {
        this.repository = repository;
    }


    @Override
    public Tracking create(Tracking tracking) {
        return this.repository.save(tracking);
    }

    @Override
    public Tracking read(String tripId) {
        return this.repository.findById(tripId).orElse(null);
    }

    @Override
    public Tracking update(Tracking tracking) {
        if (this.repository.existsById(tracking.getTripId()))
            return this.repository.save(tracking);
        return null;
    }

    @Override
    public boolean delete(String tripId) {
        if (this.repository.existsById(tripId)){
            this.repository.deleteById(tripId);
            return true;
        }
        return false;
    }

    @Override
    public Set<Tracking> getAll() {
        return (Set<Tracking>) this.repository.findAll();
    }
}