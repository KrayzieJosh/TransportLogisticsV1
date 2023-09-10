package za.ac.cput.factory;

import za.ac.cput.domain.DeliveryHistory;
import za.ac.cput.util.Helper;

public class DeliveryHistoryFactory {

    public static DeliveryHistory createNewDeliveryHistory(String deliveryOrderId, String vehicleId){

        if(Helper.isNullOrEmpty(deliveryOrderId) || Helper.isNullOrEmpty(vehicleId)){
            return null;
        }

        return new DeliveryHistory.Builder().setDeliveryOrderId(deliveryOrderId).setVehicleId(vehicleId).build();

    }
}
