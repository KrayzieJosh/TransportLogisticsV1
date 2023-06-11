package za.ac.cput.service;

import za.ac.cput.domain.Driver;

import java.util.Set;

public interface DriverService {

    Driver create(Driver driver);
    Driver read(String id);
    Driver update(Driver driver);
    boolean delete(String id);
    public Set<Driver> getAll();

}
