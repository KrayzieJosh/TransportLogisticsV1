package za.ac.cput.FactoryTest;
/*
   Entity for MaterialQuoteFactoryTest
   Author: Carlo Joshua Joseph (2206210781)
   Date: 23/06/10
*/
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.MaterialQuote;
import za.ac.cput.factory.MaterialQuoteFactory;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class MaterialQuoteFactoryTest {

    @Test
    public void createMaterialQuote() {
        MaterialQuote materialQuote = MaterialQuoteFactory.createMaterialQuote
                (Helper.generateID(), "Glass", 10.00, "100 ", 4.00);

        assertNotNull(materialQuote);
        System.out.println(materialQuote.toString());
    }
}
