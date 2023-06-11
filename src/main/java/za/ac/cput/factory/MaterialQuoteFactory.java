package za.ac.cput.factory;
/*
   Entity for MaterialQuoteFactory
   Author: Carlo Joshua Joseph (2206210781)
   Date: 23/06/10
*/
import za.ac.cput.domain.MaterialQuote;
import za.ac.cput.util.Helper;

public class MaterialQuoteFactory {
    public static MaterialQuote createMaterialQuote(String materialQuoteId, String materialName,
                                                    double materialPrice, String materialQuantity, double materialWeight) {
        materialQuoteId = Helper.generateID();

        if (Helper.isNullOrEmpty(materialQuoteId) || Helper.isNullOrEmpty(materialName)
                || Helper.isNullOrEmpty(materialQuantity)) {
            return null;
        }

        return new MaterialQuote.Builder()
                .setMaterialQuoteId(materialQuoteId)
                .setMaterialName(materialName)
                .setMaterialPrice(materialPrice)
                .setMaterialQuantity(materialQuantity)
                .setMaterialWeight(materialWeight)
                .build();
    }
}
