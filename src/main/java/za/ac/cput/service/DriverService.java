package za.ac.cput.service;

/* DeliveryHistoryService.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import za.ac.cput.domain.Driver;

import java.util.Set;


public interface DriverService {

    Driver create(Driver driver);
    Driver read(String id);
    Driver update(Driver driver);
    boolean delete(String id);
    public Set<Driver> getAll();

}
