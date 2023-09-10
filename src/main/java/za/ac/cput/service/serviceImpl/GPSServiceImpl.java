package za.ac.cput.service.serviceImpl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.GPS;
import za.ac.cput.repository.GPSRepository;
import za.ac.cput.repository.repositoryImpl.GPSRepositoryImpl;
import za.ac.cput.service.GPSService;

import java.io.Serializable;
import java.sql.Connection;

import java.util.Set;

@Service
public class GPSServiceImpl implements GPSService, Serializable {
    private static GPSService service = null;
    private GPSRepository repository = null;

    // Add a constructor that accepts a database connection
    public GPSServiceImpl(Connection connection) {
        repository = new GPSRepositoryImpl(connection);
    }

    public static GPSService getService(Connection connection) {
        if (service == null) {
            service = new GPSServiceImpl(connection);
        }
        return service;
    }


    @Override
    public GPS create(GPS gps) {
        GPS created = repository.create(gps);
        return created;
    }

    @Override
    public GPS read(String tripId) {
        GPS read = repository.read(tripId);
        return read;
    }

    @Override
    public GPS update(GPS gps) {
        GPS updated = repository.update(gps);
        return updated;
    }

    @Override
    public boolean delete(String tripId) {
        boolean success = repository.delete(tripId);
        return success;
    }

    @Override
    public Set<GPS> getAll() {
        return repository.getAll();
    }
}
