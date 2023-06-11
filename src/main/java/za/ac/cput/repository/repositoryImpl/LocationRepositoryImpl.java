package za.ac.cput.repository.repositoryImpl;

import za.ac.cput.domain.Location;
import za.ac.cput.repository.LocationRepository;
import java.util.HashSet;
import java.util.Set;

public class LocationRepositoryImpl implements LocationRepository {
    private static LocationRepositoryImpl repository = null; // nothing in Location repo
    private Set<Location> locationDB = null;

    private LocationRepositoryImpl() {
        locationDB = new HashSet<Location>();
    }

    public static LocationRepositoryImpl getRepository() {
        if (repository == null) { // will return null if empty
            repository = new LocationRepositoryImpl(); // will return an object if not
        }
        return repository;
    }

    @Override
    public Location create(Location location) {
        boolean success = locationDB.add(location);
        if (!success)
            return null;
        return location;
    }
    @Override
    public Location read(String locationId) {
        for (Location l : locationDB) {
            if (l.getLocationId().equals(locationId)) // this will return null if location id does not match
                return l;
        }
        return null;
    }
    @Override
    public Location update(Location location) {
        Location oldLocation= read(location.getLocationId());
        if (oldLocation != null) {
            locationDB.remove(oldLocation); // getting the existing location and comparing it , will update if needed and new location is returned
            locationDB.add(location);
            return location;
        }
        return null;
    }

    @Override
    public boolean delete(String locationId) { // read locationId, is found will return true, else will return false
        Location locationToDelete = read(locationId);
        if (locationToDelete == null) {
            return false;
        }
        locationDB.remove(locationToDelete);
        return true;
    }

    @Override
    public Set<Location> getAll () {

        return locationDB;
    }
}
