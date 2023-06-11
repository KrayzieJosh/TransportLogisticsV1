package za.ac.cput.service;
/* TrackingService.java
 Author: Joshua Jacobs (221144862)
 Date: 11 June 2023
*/
import za.ac.cput.domain.Tracking;
import java.util.Set;
public interface TrackingService {
    Tracking create(Tracking gps);
    Tracking read(String tripId);
    Tracking update(Tracking gps);
    boolean delete(String tripId);
    public Set<Tracking>getAll();
}
