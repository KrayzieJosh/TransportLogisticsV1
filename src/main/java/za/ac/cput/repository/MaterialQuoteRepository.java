package za.ac.cput.repository;
/*
   Entity for MaterialQuoteRepository
   Author: Carlo Joshua Joseph (2206210781)
   Date: 23/06/10
*/
import za.ac.cput.domain.MaterialQuote;

import java.util.Set;

public interface MaterialQuoteRepository extends IRepository<MaterialQuote,String> {
    public Set<MaterialQuote>getAll();
}
