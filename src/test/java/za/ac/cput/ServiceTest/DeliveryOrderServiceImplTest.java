package za.ac.cput.ServiceTest;
/*
   Entity for DeliveryOrderServiceImplTest
   Author: Carlo Joshua Joseph (2206210781)
   Date: 23/06/10
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.DeliveryOrder;
import za.ac.cput.domain.MaterialQuote;
import za.ac.cput.factory.DeliveryOrderFactory;
import za.ac.cput.factory.MaterialQuoteFactory;
import za.ac.cput.service.DeliveryOrderService;
import za.ac.cput.service.serviceImpl.DeliveryOrderServiceImpl;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class DeliveryOrderServiceImplTest {
    private static DeliveryOrderService service = null;

    public static DeliveryOrder deliveryOrder;
    public static MaterialQuote materialQuote;

   public DeliveryOrderServiceImplTest() {
        service = DeliveryOrderServiceImpl.getService();

        // Create a MaterialQuote object
        materialQuote = MaterialQuoteFactory.createMaterialQuote(
                Helper.generateID(),
                "Some Material",
                10,
                "10.6",0.9
        );

        List<MaterialQuote> materialQuotes = new ArrayList<>();
        materialQuotes.add(materialQuote);

        deliveryOrder = DeliveryOrderFactory.createDeliveryOrder(
                Helper.generateID(),
                "211 Jesus way",
                "23/06/20",
                materialQuotes
        );


    }

    @Test
    void a_create() {
        DeliveryOrder created = service.create(deliveryOrder);
        System.out.println("has been create: " + created);
        assertNotNull(created);
    }

    @Test
    void b_read() {
        DeliveryOrder read = service.read(deliveryOrder.getDeliveryOrderId());
        System.out.println("Read: " + read);
        assertNotNull(read);
    }

    @Test
    void c_update() {
        DeliveryOrder updated = new DeliveryOrder.Builder()
                .copy(deliveryOrder)
                .setDeliveryAddress("2 Jorja way, Claremont")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        String id = deliveryOrder.getDeliveryOrderId();
        boolean success = service.delete(id);
        assertTrue(success);
        System.out.println("Success: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(service.getAll());
    }
}
