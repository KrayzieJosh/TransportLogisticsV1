package za.ac.cput.repository;
/*
   Entity for MaterialQuoteRepository
   Author: Carlo Joshua Joseph (2206210781)
   Date: 23/06/10
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.MaterialQuote;

import java.util.List;
import java.util.Set;
@Repository
public interface MaterialQuoteRepository extends JpaRepository<MaterialQuote,String> {

}
