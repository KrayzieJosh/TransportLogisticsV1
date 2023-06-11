package za.ac.cput.service.serviceImpl;
/*
   Entity for MaterialQuoteServiceImpl
   Author: Carlo Joshua Joseph (2206210781)
   Date: 23/06/10
*/
import za.ac.cput.domain.MaterialQuote;
import za.ac.cput.repository.MaterialQuoteRepository;
import za.ac.cput.repository.repositoryImpl.MaterialQuoteRepositoryImpl;
import za.ac.cput.service.MaterialQuoteService;

import java.util.Set;

public class MaterialQuoteServiceImpl implements MaterialQuoteService {
    private static MaterialQuoteService service = null;
    private MaterialQuoteRepository repository = null;

    private MaterialQuoteServiceImpl() {
        repository = MaterialQuoteRepositoryImpl.getRepository();
    }

    public static MaterialQuoteService getService() {
        if (service == null) {
            service = new MaterialQuoteServiceImpl();
        }
        return service;
    }

    @Override
    public MaterialQuote create(MaterialQuote materialQuote) {
        MaterialQuote created = repository.create(materialQuote);
        return created;
    }

    @Override
    public MaterialQuote read(String materialQuoteId) {
        MaterialQuote readMaterialQuote = repository.read(materialQuoteId);
        return readMaterialQuote;
    }

    @Override
    public MaterialQuote update(MaterialQuote materialQuote) {
        MaterialQuote updateMaterialQuote = repository.update(materialQuote);
        return updateMaterialQuote;
    }

    @Override
    public boolean delete(String materialQuoteId) {
        boolean success = repository.delete(materialQuoteId);
        return success;
    }

    @Override
    public Set<MaterialQuote> getAll() {
        return repository.getAll();
    }
}
