package za.ac.cput.factory;

import java.util.List;

import za.ac.cput.domain.DeliveryHistory;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class DeliveryHistoryFactory {

    public static DeliveryHistory createNewDeliveryHistory(String deliveryOrderId, List<User> userId, String vehicleId){

        if(Helper.isStringNullOrEmpty(deliveryOrderId) || Helper.isStringNullOrEmpty(vehicleId)){
            return null;
        }

        if(Helper.isListNullOrEmpty(userId)){
            return null;
        }

        return new DeliveryHistory.Builder()
                .setUserId(userId)
                .setVehicleId(vehicleId)
                .setDeliveryOrderId(deliveryOrderId)
                .build();

    }
}
