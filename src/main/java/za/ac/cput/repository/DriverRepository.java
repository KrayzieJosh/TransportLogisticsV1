package za.ac.cput.repository;

import java.util.Set;

import za.ac.cput.domain.Driver;

public interface DriverRepository extends IRepository<Driver, String>{

    public Set<Driver> getAll();
}
