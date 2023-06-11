package za.ac.cput.factory;
/*
   Entity for DeliveryOrderFactory
   Author: Carlo Joshua Joseph (2206210781)
   Date: 23/06/10
*/
import za.ac.cput.domain.DeliveryOrder;
import za.ac.cput.domain.MaterialQuote;

import java.util.List;

public class DeliveryOrderFactory {

    public static DeliveryOrder createDeliveryOrder(String deliveryOrderId, String deliveryAddress, String deliveryDate, List<MaterialQuote> materialQuotes) {
        return new DeliveryOrder.Builder()
                .setDeliveryOrderId(deliveryOrderId)
                .setDeliveryAddress(deliveryAddress)
                .setDeliveryDate(deliveryDate)
                .setMaterialQuotes(materialQuotes)
                .build();
    }
}
