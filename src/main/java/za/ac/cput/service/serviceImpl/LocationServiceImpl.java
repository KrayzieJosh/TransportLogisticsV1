package za.ac.cput.service.serviceImpl;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Location;
import za.ac.cput.repository.LocationRepository;
import za.ac.cput.repository.repositoryImpl.LocationRepositoryImpl;
import za.ac.cput.service.LocationService;

import java.io.Serializable;
import java.util.Set;
@Service
public class LocationServiceImpl implements LocationService, Serializable {
    private static LocationService service = null;
    private LocationRepository repository = null;

    private LocationServiceImpl() {
        repository = LocationRepositoryImpl.getRepository();
    }

    public static LocationService getService() {
        if (service == null) {
            service = new LocationServiceImpl();
        }
        return service;
    }

    @Override
    public Location create(Location location) {
        Location created = repository.create(location);
        return created;
    }

    @Override
    public Location read(String locationId) {
        Location read = repository.read(locationId);
        return read;
    }

    @Override
    public Location update(Location location) {
        Location updated = repository.update(location);
        return updated;
    }
    @Override
    public boolean delete(String locationId){
        boolean success =repository.delete(locationId);
        return success;
    }
    @Override
    public Set<Location> getAll () {
        return repository.getAll();


    }
}