package za.ac.cput.service;
/* LocationService.java
 Author: Joshua Jacobs (221144862)
 Date: 11 June 2023
*/
import za.ac.cput.domain.Location;
import java.util.Set;
public interface LocationService {
    Location create(Location location);
    Location read(String locationId);
    Location update(Location location);
    boolean delete(String locationId);
    public Set<Location>getAll();
}