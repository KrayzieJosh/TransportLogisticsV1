package za.ac.cput.service;
/*
   Entity for MaterialQuoteService
   Author: Carlo Joshua Joseph (2206210781)
   Date: 23/06/10
*/
import za.ac.cput.domain.MaterialQuote;

import java.util.List;
import java.util.Set;

public interface MaterialQuoteService {

    MaterialQuote create(MaterialQuote materialQuote);

    MaterialQuote read(String materialQuoteId);

    MaterialQuote update(MaterialQuote materialQuote);

    boolean delete(String materialQuoteId);

    List<MaterialQuote> getAll();
}
