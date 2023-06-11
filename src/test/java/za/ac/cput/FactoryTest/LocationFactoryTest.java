package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.domain.Location;
import za.ac.cput.factory.LocationFactory;
import za.ac.cput.util.Helper;

class LocationFactoryTest {

    @Test
    void createLocation() {
        Location location = LocationFactory.createLocation(
                Helper.generateID(),
                "BUCO",
                50,
                "4th Avenue",
                "Cape Town",
                7580

        );

        assertNotNull(location);
        System.out.println(location.toString());
    }
}