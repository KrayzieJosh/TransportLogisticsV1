package za.ac.cput.service;
/* GPSService.java
 Author: Joshua Jacobs (221144862)
 Date: 11 June 2023
*/
import za.ac.cput.domain.GPS;
import java.util.Set;
public interface GPSService {
    GPS create(GPS gps);
    GPS read(String tripId);
    GPS update(GPS gps);
    boolean delete(String tripId);
    public Set<GPS>getAll();
}