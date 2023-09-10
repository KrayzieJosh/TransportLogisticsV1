package za.ac.cput.factory;

import za.ac.cput.domain.DeliveryOrder;
import za.ac.cput.domain.MaterialQuote;

import java.util.List;

public class DeliveryOrderFactory {

    public static DeliveryOrder createDeliveryOrder(
            String deliveryOrderId,
            String deliveryAddress,
            String deliveryDate,
            List<MaterialQuote> materialQuotes
    ) {
        return new DeliveryOrder.DeliveryOrderBuilder()
                .setDeliveryOrderId(deliveryOrderId)
                .setDeliveryAddress(deliveryAddress)
                .setDeliveryDate(deliveryDate)
                .setMaterialQuotes(materialQuotes)
                .build();
    }
}