package za.ac.cput.service.serviceImpl;
/*
   Entity for MaterialQuoteServiceImpl
   Author: Carlo Joshua Joseph (2206210781)
   Date: 23/06/10
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.MaterialQuote;
import za.ac.cput.repository.MaterialQuoteRepository;

import za.ac.cput.service.MaterialQuoteService;

import java.util.List;
import java.util.Set;
@Service
public class MaterialQuoteServiceImpl implements MaterialQuoteService {

    private MaterialQuoteRepository repository ;

    @Autowired
    private MaterialQuoteServiceImpl(MaterialQuoteRepository repository) {
        this.repository=repository;
    }


    @Override
    public MaterialQuote create(MaterialQuote materialQuote) {
        return this.repository.save(materialQuote);
    }

    @Override
    public MaterialQuote read(String materialQuoteId) {
        return this.repository.findById(materialQuoteId).orElse(null);
    }

    @Override
    public MaterialQuote update(MaterialQuote materialQuote) {
        if(this.repository.existsById(materialQuote.getMaterialQuoteId()))
            return this.repository.save(materialQuote);
        return null;
    }

    @Override
    public boolean delete(String materialQuoteId) {
        if (this.repository.existsById(materialQuoteId)){
            this.repository.deleteById(materialQuoteId);
            return true;
        }
        return false;
    }

    @Override
    public List<MaterialQuote> getAll() {
        return this.repository.findAll();
    }
}
