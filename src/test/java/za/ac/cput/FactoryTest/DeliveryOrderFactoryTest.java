package za.ac.cput.FactoryTest;
/*
   Entity for DeliveryOrderFactoryTest
   Author: Carlo Joshua Joseph (2206210781)
   Date: 23/06/10
*/
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.DeliveryOrder;
import za.ac.cput.domain.MaterialQuote;
import za.ac.cput.factory.DeliveryOrderFactory;
import za.ac.cput.factory.MaterialQuoteFactory;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryOrderFactoryTest {

    @Test
    public void createDeliveryOrder() {
        List<MaterialQuote> materialQuotes = new ArrayList<>();
        // Add material quotes to the list
        MaterialQuote materialQuote1 = MaterialQuoteFactory.createMaterialQuote(
                Helper.generateID(), "silver", 14.74, "100 ", 74.25);
        MaterialQuote materialQuote2 = MaterialQuoteFactory.createMaterialQuote(
                Helper.generateID(), "Steele", 89.74, "50 ", 41.75);
        materialQuotes.add(materialQuote1);
        materialQuotes.add(materialQuote2);

        DeliveryOrder deliveryOrder = DeliveryOrderFactory.createDeliveryOrder(
                Helper.generateID(), "123Tokai Road, Cape Town", "2023-06-30", materialQuotes);

        assertNotNull(deliveryOrder);
        System.out.println(deliveryOrder.toString());
    }
}