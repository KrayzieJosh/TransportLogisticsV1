package za.ac.cput.service.serviceImpl;

/* GPSServiceImpl.java
 Entities for the serviceImpl
 Author: Joshua Jacobs (221144862)
 Date: 9 June 2023
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.GPS;
import za.ac.cput.repository.GPSRepository;
import za.ac.cput.service.GPSService;

import java.util.Set;


@Service
public class GPSServiceImpl implements GPSService {

    private GPSRepository repository;
    @Autowired
    private GPSServiceImpl(GPSRepository repository) {
        this.repository = repository;
    }


    @Override
    public GPS create(GPS gps) {
        return this.repository.save(gps);
    }

    @Override
    public GPS read(String tripId) {
        return this.repository.findById(tripId).orElse(null);
    }

    @Override
    public GPS update(GPS gps) {
        if (this.repository.existsById(gps.getTripId()))
            return this.repository.save(gps);
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
    public Set<GPS> getAll() {
        return (Set<GPS>) this.repository.findAll();
    }
}