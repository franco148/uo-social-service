package com.umssonline.social.services;

import com.umssonline.social.models.Resource;
import com.umssonline.social.repositories.api.ExtendedResourceDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;

@Service("resourceService")
public class ResourceServiceImpl implements SocialService<Resource> {

    //region Properties
    @javax.annotation.Resource
    private ExtendedResourceDao resourceDao;
    //endregion

    //region Properties
    @Transactional(readOnly = true)
    @Override
    public Resource findById(Serializable id) throws Exception {
        Resource resourceFromDb = resourceDao.findById(id);

        if (resourceFromDb == null) {
            throw new Exception("Resource with the specified ID does not exist.");
        }
        return resourceFromDb;
    }

    @Override
    public Collection<Resource> findByProperty(String propertyName) {
        return null;
    }

    @Override
    public Collection<Resource> findAll() {
        return resourceDao.findAll();
    }

    @Override
    public Resource save(Resource resource) {
        return resourceDao.create(resource);
    }

    @Override
    public Resource update(Resource resource) {
        return resourceDao.update(resource);
    }

    @Override
    public void delete(Resource resource) {
        resourceDao.delete(resource);
    }

    @Override
    public void deleteById(Serializable id) {
        resourceDao.deleteById(id);
    }
    //endregion
}
