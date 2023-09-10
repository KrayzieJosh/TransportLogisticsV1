package za.ac.cput.ServiceTest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.MaterialQuote;
import za.ac.cput.factory.MaterialQuoteFactory;
import za.ac.cput.service.MaterialQuoteService;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

/*
   Entity for MaterialQuoteServiceImplTest
   Author: Carlo Joshua Joseph (2206210781)
   Date: 23/06/10
*/
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class MaterialQuoteServiceImplTest {
    @Autowired
    private  MaterialQuoteService service;

    public static MaterialQuote materialQuote = MaterialQuoteFactory.createMaterialQuote(Helper.generateID(), "Wood", 10, "100 ", 5.00
    );

//    public MaterialQuoteServiceImplTest() {
//        service = MaterialQuoteServiceImpl.getService();
//    }

    @Test
    void a_create() {
        MaterialQuote created = service.create(materialQuote);
        assertEquals(materialQuote.getMaterialQuoteId(),created.getMaterialQuoteId());
        System.out.println(created);
    }

    @Test
    void b_read() {
        MaterialQuote read = service.read(materialQuote.getMaterialQuoteId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        MaterialQuote newMaterialQuote = new MaterialQuote.Builder().copy(materialQuote).setMaterialName("Iron").build();
        MaterialQuote updated=service.update(newMaterialQuote);

        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    @Disabled
    void e_delete() {
    }

    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(service.getAll());
    }
}