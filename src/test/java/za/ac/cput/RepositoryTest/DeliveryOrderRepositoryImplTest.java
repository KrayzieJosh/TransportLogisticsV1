package za.ac.cput.RepositoryTest;
/*
   Entity for DeliveryOrderRepositoryImplTest
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
import za.ac.cput.repository.repositoryImpl.DeliveryOrderRepositoryImpl;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class DeliveryOrderRepositoryImplTest {

    private static DeliveryOrderRepositoryImpl repository = DeliveryOrderRepositoryImpl.getRepository();
    private static DeliveryOrder deliveryOrder;

    @Test
    void a_create() {
        List<MaterialQuote> materialQuotes = new ArrayList<>();
        MaterialQuote materialQuote1 = MaterialQuoteFactory.createMaterialQuote(
                Helper.generateID(), "Sulfur", 10.00, "100 ", 5.00);
        MaterialQuote materialQuote2 = MaterialQuoteFactory.createMaterialQuote(
                Helper.generateID(), "Copper", 15.00, "50 ", 8.00);
        materialQuotes.add(materialQuote1);
        materialQuotes.add(materialQuote2);

        deliveryOrder = DeliveryOrderFactory.createDeliveryOrder(
                Helper.generateID(), "123 KFC lane, City", "2023-06-12", materialQuotes);

        DeliveryOrder created = repository.create(deliveryOrder);
        assertEquals(deliveryOrder.getDeliveryOrderId(), created.getDeliveryOrderId());
        System.out.println("Has been created: " + created);
    }

    @Test
    void b_read() {
        DeliveryOrder read = repository.read(deliveryOrder.getDeliveryOrderId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        List<MaterialQuote> materialQuotes = new ArrayList<>();
        MaterialQuote materialQuote3 = MaterialQuoteFactory.createMaterialQuote(
                Helper.generateID(), "Mercury", 20.00, "80 ", 4.0);
        materialQuotes.add(materialQuote3);

        DeliveryOrder updated = new DeliveryOrder.DeliveryOrderBuilder().copy(deliveryOrder)
                .setDeliveryDate("2023-06-15")
                .setMaterialQuotes(materialQuotes)
                .build();

        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(deliveryOrder.getDeliveryOrderId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Display all:");
        System.out.println(repository.getAll());
    }
}
