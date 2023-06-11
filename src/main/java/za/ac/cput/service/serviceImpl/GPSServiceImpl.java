package za.ac.cput.service.serviceImpl;
import za.ac.cput.domain.GPS;
import za.ac.cput.repository.GPSRepository;
import za.ac.cput.repository.repositoryImpl.GPSRepositoryImpl;
import za.ac.cput.service.GPSService;

import java.util.Set;

public class GPSServiceImpl implements GPSService {
    private static GPSService service = null;
    private GPSRepository repository = null;

    private GPSServiceImpl() {
        repository = GPSRepositoryImpl.getRepository();
    }

    public static GPSService getService() {
        if (service == null) {
            service = new GPSServiceImpl();
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
    public boolean delete(String tripId){
        boolean success =repository.delete(tripId);
        return success;
    }
    @Override
    public Set<GPS> getAll () {
        return repository.getAll();


    }
}