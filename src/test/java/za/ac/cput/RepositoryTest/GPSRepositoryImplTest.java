package za.ac.cput.RepositoryTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.GPS;
import za.ac.cput.factory.GPSFactory;
import za.ac.cput.repository.repositoryImpl.GPSRepositoryImpl;
import za.ac.cput.util.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class GPSRepositoryImplTest {

    private static GPSRepositoryImpl repository;
    private static GPS gps;

    // Initialize the database connection
    static {
        try {
            Connection connection = getConnection();
            repository = new GPSRepositoryImpl(connection);
            gps = GPSFactory.createGPS(Helper.generateID(), "1111-4568-9635", "1789-9654-14203");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void a_create() {
        GPS created = repository.create(gps);
        assertEquals(gps.getTripId(), created.getTripId());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        GPS read = repository.read(gps.getTripId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        GPS updated = new GPS.Builder().copy(gps).setStartLocationId("111-456-63")
                .build();

        GPS result = repository.update(updated);

        assertNotNull(result);

        assertEquals("111-456-63", result.getStartLocationId());

        System.out.println("Update: " + result);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(gps.getTripId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Display all:");
        System.out.println(repository.getAll());
    }

    // Method for a database connection
    private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/your_database";
        Properties properties = new Properties();
        properties.setProperty("user", "your_username");
        properties.setProperty("password", "your_password");
        return DriverManager.getConnection(url, properties);
    }
}
