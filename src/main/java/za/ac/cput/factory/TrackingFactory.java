package za.ac.cput.factory;

import za.ac.cput.domain.Tracking;
import za.ac.cput.util.Helper;

public class TrackingFactory {
    public static Tracking createTracker(String tripId,int stops, int detours) {
        tripId = Helper.generateID();
        if ((Helper.isNullOrEmpty(tripId) || stops <0||detours <0)) {
            return null;
        }
        return new Tracking.Builder()
                .setTripId(tripId)
                .setStops(stops)
                .setDetours(detours)
                .build();
    }
}
