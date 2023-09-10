package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Driver;
import za.ac.cput.repository.DriverRepository;
import za.ac.cput.service.DriverService;

import java.util.List;
import java.util.Set;

@Service
public class DriverServiceImpl implements DriverService {

    private DriverRepository repository;

    @Autowired
    private DriverServiceImpl(DriverRepository repository){
        this.repository = repository;
    }

    @Override
    public Driver create(Driver driver) {
        return this.repository.save(driver);
    }

    @Override
    public Driver read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Driver update(Driver driver) {
        if(this.repository.existsById(driver.getDriverId())){
            return this.repository.save(driver);
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Driver> getAll() {
        return this.repository.findAll();
    }

}
