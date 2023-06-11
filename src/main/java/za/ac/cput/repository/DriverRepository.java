package za.ac.cput.repository;

/* DriverRepository.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import java.util.Set;

import za.ac.cput.domain.Driver;

public interface DriverRepository extends IRepository<Driver, String>{

    public Set<Driver> getAll();
}
