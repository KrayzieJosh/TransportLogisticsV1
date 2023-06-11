package za.ac.cput.repository.repositoryImpl;

import za.ac.cput.domain.Tracking;
import za.ac.cput.repository.TrackingRepository;

import java.util.HashSet;
import java.util.Set;

public class TrackingRepositoryImpl implements TrackingRepository {
    private static TrackingRepositoryImpl repository = null; // nothing in Tracking repo
    private Set<Tracking> TrackingDB = null;

    private TrackingRepositoryImpl() {
        TrackingDB = new HashSet<Tracking>();
    }

    public static TrackingRepositoryImpl getRepository() {
        if (repository == null) { // will return null if empty
            repository = new TrackingRepositoryImpl(); // will return an object if not
        }
        return repository;
    }

    @Override
    public Tracking create(Tracking tracking) {
        boolean success = TrackingDB.add(tracking);
        if (!success)
            return null;
        return tracking;
    }
    @Override
    public Tracking read(String tripId) {
        for (Tracking t : TrackingDB) {
            if (t.getTripId().equals(tripId)) // this will return null if trip id does not match
                return t;
        }
        return null;
    }
    @Override
    public Tracking update(Tracking tracking) {
        Tracking oldTracking= read(tracking.getTripId());
        if (oldTracking != null) {
            TrackingDB.remove(oldTracking); // getting the existing Tracking and comparing it , will update if needed and new Tracking is returned
            TrackingDB.add(tracking);
            return tracking;
        }
        return null;
    }

    @Override
    public boolean delete(String tripId) { // read locationId, is found will return true, else will return false
        Tracking trackingToDelete = read(tripId);
        if (trackingToDelete == null) {
            return false;
        }
        TrackingDB.remove(trackingToDelete);
        return true;
    }

    @Override
    public Set<Tracking> getAll () {

        return TrackingDB;
    }
}
