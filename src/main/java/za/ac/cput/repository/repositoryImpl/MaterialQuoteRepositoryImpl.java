package za.ac.cput.repository.repositoryImpl;
/*
   Entity for MaterialQuoteRepository
   Author: Carlo Joshua Joseph (2206210781)
   Date: 23/06/10
*/
import java.util.HashSet;
import java.util.Set;

import za.ac.cput.domain.MaterialQuote;
import za.ac.cput.repository.MaterialQuoteRepository;

public class MaterialQuoteRepositoryImpl implements MaterialQuoteRepository {
    private static MaterialQuoteRepositoryImpl repository = null;
    private Set<MaterialQuote> materialQuoteDB = null;

    private MaterialQuoteRepositoryImpl() {
        materialQuoteDB = new HashSet<>();
    }

    public static MaterialQuoteRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new MaterialQuoteRepositoryImpl();
        }
        return repository;
    }

    @Override
    public MaterialQuote create(MaterialQuote materialQuote) {
        boolean success = materialQuoteDB.add(materialQuote);
        if (!success)
            return null;
        return materialQuote;
    }

    @Override
    public MaterialQuote read(String materialQuoteId) {
        for (MaterialQuote mq : materialQuoteDB) {
            if (mq.getMaterialQuoteId().equals(materialQuoteId))
                return mq;
        }
        return null;
    }

    @Override
    public MaterialQuote update(MaterialQuote materialQuote) {
        MaterialQuote oldMaterialQuote = read(materialQuote.getMaterialQuoteId());
        if (oldMaterialQuote != null) {
            materialQuoteDB.remove(oldMaterialQuote);
            materialQuoteDB.add(materialQuote);
            return materialQuote;
        }
        return null;
    }

    @Override
    public boolean delete(String materialQuoteId) {
        MaterialQuote materialQuoteToDelete = read(materialQuoteId);
        if (materialQuoteToDelete == null) {
            return false;
        }
        materialQuoteDB.remove(materialQuoteToDelete);
        return true;
    }

    @Override
    public Set<MaterialQuote> getAll() {
        return materialQuoteDB;
    }
}
