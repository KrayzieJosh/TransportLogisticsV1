package za.ac.cput.service.serviceImpl;

/* DriverServiceImpl.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import za.ac.cput.domain.Driver;
import za.ac.cput.repository.DriverRepository;
import za.ac.cput.service.DriverService;

import java.util.Set;

public class DriverServiceImpl implements DriverService {

    private static DriverService service = null;

    private DriverRepository repository = null;

    private DriverServiceImpl() {repository = DriverRepositoryImpl.getRepository();}

    public static DriverService getService() {
        if (service == null) {
            service = new DriverServiceImpl();
        }
        return service;
    }

    @Override
    public Driver create(Driver driver) {
        Driver created = repository.create(driver);
        return created;
    }

    @Override
    public Driver read(String driverId) {
        Driver readDriver = repository.read(driverId);
        return readDriver;
    }

    @Override
    public Driver update(Driver driver) {
        Driver updateDriver = repository.update(driver);
        return updateDriver;
    }

    @Override
    public boolean delete(String driverId) {
        boolean success = repository.delete(driverId);
        return success;
    }

    @Override
    public Set<Driver> getAll() {
        return repository.getAll();
    }
}
