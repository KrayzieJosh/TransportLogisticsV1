package za.ac.cput.repository.repositoryImpl;

/* DriverRepositoryImpl.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import java.util.HashSet;
import java.util.Set;

import za.ac.cput.domain.Driver;
import za.ac.cput.repository.DriverRepository;

public class DriverRepositoryImpl implements DriverRepository {

    private static DriverRepositoryImpl repository= null;
    private Set<Driver> driverDB;

    private DriverRepositoryImpl(){ driverDB = new HashSet<Driver>();}

    public static DriverRepositoryImpl getRepository(){
        if(repository == null) { repository = new DriverRepositoryImpl();}
        return repository;
    }

    //Methods:
    @Override
    public Driver create(Driver driver) {
        boolean success = driverDB.add(driver);
        if(!success)
            return null;
        return driver;
    }

    @Override
    public Driver read(String userId) {
        for(Driver d : driverDB){
            if(d.getUserId().equals(userId)){
                return d;
            }
        }
        return null;
    }

    @Override
    public Driver update(Driver driver) {
        Driver oldDriver = read(driver.getUserId());
        if(oldDriver != null){
            driverDB.remove(oldDriver);
            driverDB.add(driver);
            return driver;
        }
        return null;
    }

    @Override
    public boolean delete(String userID) {
        Driver driverToDelete = read(userID);
        if(driverToDelete == null){
            return false;
        }
        driverDB.remove(driverToDelete);
        return true;
    }

    @Override
    public Set<Driver> getAll() {
        return driverDB;
    }
}
