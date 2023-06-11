package za.ac.cput.service.serviceImpl;

import za.ac.cput.domain.DeliveryVehicle;
import za.ac.cput.repository.DeliveryVehicleRepository;
import za.ac.cput.repository.repositoryImpl.DeliveryVehicleRepositoryImpl;
import za.ac.cput.service.DeliveryVehicleService;

import java.util.Set;

public class DeliveryVehicleServiceImpl implements DeliveryVehicleService {
    private static DeliveryVehicleService service = null;
    private DeliveryVehicleRepository repository = null;

    private DeliveryVehicleServiceImpl() {
        repository = DeliveryVehicleRepositoryImpl.getRepository();
    }

    public static DeliveryVehicleService getService() {
        if (service == null) {
            service = new DeliveryVehicleServiceImpl();
        }
        return service;
    }

    @Override
    public DeliveryVehicle create(DeliveryVehicle deliveryVehicle) {
        DeliveryVehicle created = repository.create(deliveryVehicle);
        return created;
    }

    @Override
    public DeliveryVehicle read(String vehicleId) {
       DeliveryVehicle readVehicle = repository.read(vehicleId);
        return readVehicle;
    }

    @Override
    public DeliveryVehicle update(DeliveryVehicle deliveryVehicle) {
        DeliveryVehicle updateVehicle= repository.update(deliveryVehicle);
        return updateVehicle;
    }
    @Override
    public boolean delete(String vehicleId){
        boolean success =repository.delete(vehicleId);
        return success;
    }
    @Override
    public Set<DeliveryVehicle> getAll () {
        return repository.getAll();
    }
}


