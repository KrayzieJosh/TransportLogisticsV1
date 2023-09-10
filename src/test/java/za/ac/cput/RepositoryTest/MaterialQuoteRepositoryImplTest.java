package za.ac.cput.RepositoryTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.MaterialQuote;
import za.ac.cput.factory.MaterialQuoteFactory;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class MaterialQuoteRepositoryImplTest {

    private static MaterialQuoteRepositoryImpl repository = MaterialQuoteRepositoryImpl.getRepository();
    private static MaterialQuote materialQuote = MaterialQuoteFactory.createMaterialQuote(
            Helper.generateID(), "Peroxide", 10.900, "100 ", 5.00);

    @Test
    void a_create() {
        MaterialQuote created = repository.create(materialQuote);
        assertEquals(materialQuote.getMaterialQuoteId(), created.getMaterialQuoteId());
        System.out.println("has been created: " + created);
    }

    @Test
    void b_read() {
        MaterialQuote read = repository.read(materialQuote.getMaterialQuoteId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        MaterialQuote updated = new MaterialQuote.Builder().copy(materialQuote)
                .setMaterialQuantity("200 ")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(materialQuote.getMaterialQuoteId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Display all:");
        System.out.println(repository.getAll());
    }
}
