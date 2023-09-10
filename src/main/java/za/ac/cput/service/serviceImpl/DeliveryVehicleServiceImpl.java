package za.ac.cput.service.serviceImpl;


/* DeliveryVehicleServiceImpl.java
 Entity for the serviceImpl
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.DeliveryVehicle;
import za.ac.cput.repository.DeliveryVehicleRepository;
import za.ac.cput.service.DeliveryVehicleService;
import java.util.List;
@Service
public class DeliveryVehicleServiceImpl implements DeliveryVehicleService {
    private DeliveryVehicleRepository repository;

    @Autowired
    private DeliveryVehicleServiceImpl(DeliveryVehicleRepository repository) {
        this.repository = repository;
    }
    @Override
    public DeliveryVehicle create(DeliveryVehicle deliveryVehicle) {

        return this.repository.save(deliveryVehicle);
    }

    @Override
    public DeliveryVehicle read(String vehicleId) {
        return this.repository.findById(vehicleId).orElse(null);
        //if it
    }
    @Override
    public DeliveryVehicle update(DeliveryVehicle deliveryVehicle) {
        if(this.repository.existsById(deliveryVehicle.getVehicleId()))
            return this.repository.save(deliveryVehicle);
        return null;
    }
    @Override
    public boolean delete(String vehicleId) {
        if(this.repository.existsById(vehicleId)) {
            this.repository.deleteById(vehicleId);
            return true;
        }
        return false;
    }
    @Override
    public List<DeliveryVehicle> getAll() {
        return this.repository.findAll();
    }
}
