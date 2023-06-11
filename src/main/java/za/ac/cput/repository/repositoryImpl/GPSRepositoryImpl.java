package za.ac.cput.repository.repositoryImpl;

import za.ac.cput.domain.GPS;
import za.ac.cput.repository.GPSRepository;
import java.util.HashSet;
import java.util.Set;

public class GPSRepositoryImpl implements GPSRepository {
    private static GPSRepositoryImpl repository = null; // nothing in Location repo
    private Set<GPS> GPSDB = null;

    private GPSRepositoryImpl() {
        GPSDB = new HashSet<GPS>();
    }

    public static GPSRepositoryImpl getRepository() {
        if (repository == null) { // will return null if empty
            repository = new GPSRepositoryImpl(); // will return an object if not
        }
        return repository;
    }

    @Override
    public GPS create(GPS gps) {
        boolean success = GPSDB.add(gps);
        if (!success)
            return null;
        return gps;
    }
    @Override
    public GPS read(String tripId) {
        for (GPS g : GPSDB) {
            if (g.getTripId().equals(tripId)) // this will return null if trip id does not match
                return g;
        }
        return null;
    }
    @Override
    public GPS update(GPS gps) {
        GPS oldGPS= read(gps.getTripId());
        if (oldGPS != null) {
            GPSDB.remove(oldGPS); // getting the existing GPS and comparing it , will update if needed and new GPS is returned
            GPSDB.add(gps);
            return gps;
        }
        return null;
    }

    @Override
    public boolean delete(String tripId) { // read locationId, is found will return true, else will return false
        GPS gpsToDelete = read(tripId);
        if (gpsToDelete == null) {
            return false;
        }
        GPSDB.remove(gpsToDelete);
        return true;
    }

    @Override
    public Set<GPS> getAll () {

        return GPSDB;
    }
}
