package com.umssonline.social.services.impl;

import com.umssonline.social.models.entity.Resource;
import com.umssonline.social.repositories.api.ExtendedResourceDao;
import com.umssonline.social.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

    //region Properties
    @Autowired
    private ExtendedResourceDao resourceDao;
    //endregion

    //region Properties
    @Transactional(readOnly = true)
    @Override
    public Resource findById(Serializable id) {
        Resource resourceFromDb = resourceDao.findById(id);

        if (resourceFromDb == null) {
            //throw new Exception("Resource with the specified ID does not exist.");
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
