package za.ac.cput.factory;

import za.ac.cput.domain.GPS;
import za.ac.cput.util.Helper;

public class GPSFactory {
    public static GPS createGPS(String tripId, String startLocationId, String storeLocationId) {
        tripId = Helper.generateID();
        if ((Helper.isNullOrEmpty(tripId) || Helper.isNullOrEmpty(startLocationId) || Helper.isNullOrEmpty(storeLocationId))) {
            return null;
        }
        return new GPS.Builder()
                .setTripId(tripId)
                .setStartLocationId(startLocationId)
                .setStoreLocationId(storeLocationId)
                .build();
    }
}
