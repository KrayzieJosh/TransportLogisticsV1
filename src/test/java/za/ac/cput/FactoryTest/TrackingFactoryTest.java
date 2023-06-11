package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.domain.Tracking;
import za.ac.cput.factory.TrackingFactory;
import za.ac.cput.util.Helper;

class TrackingFactoryTest {

    @Test
    void createTracker() {
        Tracking tracking = TrackingFactory.createTracker(
                Helper.generateID(),
                1,
                50

        );

        assertNotNull(tracking);
        System.out.println(tracking.toString());
    }
}