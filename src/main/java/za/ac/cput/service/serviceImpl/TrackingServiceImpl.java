package za.ac.cput.service.serviceImpl;
import za.ac.cput.domain.Tracking;
import za.ac.cput.repository.TrackingRepository;
import za.ac.cput.repository.repositoryImpl.TrackingRepositoryImpl;
import za.ac.cput.service.TrackingService;

import java.util.Set;

public class TrackingServiceImpl implements TrackingService {
    private static TrackingService service = null;
    private TrackingRepository repository = null;

    private TrackingServiceImpl() {
        repository = TrackingRepositoryImpl.getRepository();
    }

    public static TrackingService getService() {
        if (service == null) {
            service = new TrackingServiceImpl();
        }
        return service;
    }

    @Override
    public Tracking create(Tracking tracking) {
        Tracking created = repository.create(tracking);
        return created;
    }

    @Override
    public Tracking read(String tripId) {
        Tracking read = repository.read(tripId);
        return read;
    }

    @Override
    public Tracking update(Tracking tracking) {
        Tracking updated = repository.update(tracking);
        return updated;
    }
    @Override
    public boolean delete(String tripId){
        boolean success =repository.delete(tripId);
        return success;
    }
    @Override
    public Set<Tracking> getAll () {
        return repository.getAll();


    }
}