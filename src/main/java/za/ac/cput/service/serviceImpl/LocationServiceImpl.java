package za.ac.cput.service.serviceImpl;

/* LocationServiceImpl.java
 Entities for the serviceImpl
 Author: Joshua Jacobs (221144862)
 Date: 9 June 2023
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Location;
import za.ac.cput.repository.LocationRepository;
import za.ac.cput.service.LocationService;

import java.util.Set;


@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository repository;
    @Autowired
    private LocationServiceImpl(LocationRepository repository) {
        this.repository = repository;
    }


    @Override
    public Location create(Location location) {
        return this.repository.save(location);
    }

    @Override
    public Location read(String locationId) {
        return this.repository.findById(locationId).orElse(null);
    }

    @Override
    public Location update(Location location) {
        if (this.repository.existsById(location.getLocationId()))
            return this.repository.save(location);
        return null;
    }

    @Override
    public boolean delete(String locationId) {
        if (this.repository.existsById(locationId)){
            this.repository.deleteById(locationId);
            return true;
        }
        return false;
    }

    @Override
    public Set<Location> getAll() {
        return (Set<Location>) this.repository.findAll();
    }
}