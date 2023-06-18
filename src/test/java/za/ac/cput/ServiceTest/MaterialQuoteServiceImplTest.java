package za.ac.cput.ServiceTest;
/*
   Entity for DeliveryOrder
   Author: Carlo Joshua Joseph (2206210781)
   Date: 23/06/10
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.MaterialQuote;
import za.ac.cput.factory.MaterialQuoteFactory;
import za.ac.cput.service.MaterialQuoteService;
import za.ac.cput.service.serviceImpl.MaterialQuoteServiceImpl;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class MaterialQuoteServiceImplTest {
    private static MaterialQuoteService service = null;

    public static MaterialQuote materialQuote = MaterialQuoteFactory.createMaterialQuote(
            Helper.generateID(),
            "Wood",
            10,
            "100 ", 5.00
    );

    public MaterialQuoteServiceImplTest() {
        service = MaterialQuoteServiceImpl.getService();
    }

    @Test
    void a_create() {
        MaterialQuote created = service.create(materialQuote);
        System.out.println("has been create: " + created);
        assertNotNull(created);
    }

    @Test
    void b_read() {
        MaterialQuote read = service.read(materialQuote.getMaterialQuoteId());
        System.out.println("Read: " + read);
        assertNotNull(read);
    }

    @Test
    void c_update() {
        MaterialQuote updated = new MaterialQuote.Builder()
                .copy(materialQuote)
                .setMaterialName("Updated Material")
                .build();

        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        String id = materialQuote.getMaterialQuoteId();
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
