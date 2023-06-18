package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.domain.GPS;
import za.ac.cput.factory.GPSFactory;
import za.ac.cput.util.Helper;

class GPSFactoryTest {

    @Test
    void createGPS() {
        GPS gps = GPSFactory.createGPS(
                Helper.generateID(),
                "111-111-456",
                "2142-3245-3456"

        );

        assertNotNull(gps);
        System.out.println(gps.toString());
    }
}