package za.ac.cput.repository.repositoryImpl;

import za.ac.cput.domain.GPS;
import za.ac.cput.repository.GPSRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class GPSRepositoryImpl implements GPSRepository {
    // Initialize your database connection here
    private Connection connection;

    public GPSRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public GPS create(GPS gps) {
        String insertQuery = "INSERT INTO gps (trip_id, latitude, longitude, start_location_id, store_location_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, gps.getTripId());
            preparedStatement.setString(2, gps.getStartLocationId());
            preparedStatement.setString(3, gps.getStoreLocationId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return gps;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public GPS read(String tripId) {
        String selectQuery = "SELECT * FROM gps WHERE trip_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, tripId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String tripIdValue = resultSet.getString("trip_id");
                double latitude = resultSet.getDouble("latitude");
                double longitude = resultSet.getDouble("longitude");
                String startLocationId = resultSet.getString("start_location_id");
                String storeLocationId = resultSet.getString("store_location_id");

                return new GPS(tripIdValue, startLocationId, storeLocationId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public GPS update(GPS gps) {
        String updateQuery = "UPDATE gps SET latitude = ?, longitude = ?, start_location_id = ?, store_location_id = ? WHERE trip_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, gps.getStartLocationId());
            preparedStatement.setString(2, gps.getStoreLocationId());
            preparedStatement.setString(3, gps.getTripId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return gps;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public boolean delete(String tripId) {
        String deleteQuery = "DELETE FROM gps WHERE trip_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setString(1, tripId);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Set<GPS> getAll() {
        Set<GPS> gpsSet = new HashSet<>();
        String selectAllQuery = "SELECT * FROM gps";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectAllQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String tripId = resultSet.getString("trip_id");
                String startLocationId = resultSet.getString("start_location_id");
                String storeLocationId = resultSet.getString("store_location_id");

                GPS gps = new GPS(tripId, startLocationId, storeLocationId);
                gpsSet.add(gps);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gpsSet;
    }

}
