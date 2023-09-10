package za.ac.cput.ServiceTest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.DeliveryOrder;
import za.ac.cput.domain.MaterialQuote;
import za.ac.cput.factory.DeliveryOrderFactory;
import za.ac.cput.factory.MaterialQuoteFactory;
import za.ac.cput.service.DeliveryOrderService;
import za.ac.cput.service.serviceImpl.DeliveryOrderServiceImpl;
import za.ac.cput.util.Helper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
/*
   Entity for DeliveryOrderServiceImplTest
   Author: Carlo Joshua Joseph (2206210781)
   Date: 23/06/10
*/
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class DeliveryOrderServiceImplTest {
    @Autowired
    private DeliveryOrderServiceImpl service;

    private static List<MaterialQuote> materialQuotes = Arrays.asList(MaterialQuoteFactory.createMaterialQuote(
            Helper.generateID(),"Wood",11,"12",12)

    );

    private static DeliveryOrder deliveryOrder = DeliveryOrderFactory.createDeliveryOrder(
            Helper.generateID(),
            "123 Main Street",
            "2023-09-15",
            materialQuotes
    );

    @Test
    void a_create() {
        DeliveryOrder created = service.create(deliveryOrder);
        assertEquals(deliveryOrder.getDeliveryOrderId(), created.getDeliveryOrderId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        DeliveryOrder read = service.read(deliveryOrder.getDeliveryOrderId());
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        DeliveryOrder newDeliveryOrder = new DeliveryOrder.DeliveryOrderBuilder()
                .copy(deliveryOrder)
                .setDeliveryAddress("Updated Address")
                .build();
        DeliveryOrder updated = service.update(newDeliveryOrder);

        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Disabled
    @Test
    void e_delete() {
        // Implement the delete test as needed
    }

    @Test
    void d_getAll() {
        System.out.println("Get All:");
        List<DeliveryOrder> deliveryOrders = service.getAll();
        deliveryOrders.forEach(System.out::println);
    }
}
