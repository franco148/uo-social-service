package com.umssonline.social.services.impl;

import com.umssonline.social.models.entity.Resource;
import com.umssonline.social.repositories.api.ExtendedResourceDao;
import com.umssonline.social.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
            throw new EntityNotFoundException("Resource with the specified ID does not exist.");
        }

        resourceFromDb.getComment().getMessages();

        return resourceFromDb;
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Resource> findByProperty(String propertyName) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Resource> findAll() {
        return resourceDao.findAll();
    }

    @Transactional
    @Override
    public Resource save(Resource resource) {
        return resourceDao.create(resource);
    }

    @Transactional
    @Override
    public Resource update(Resource resource) {
        return resourceDao.update(resource);
    }

    @Transactional
    @Override
    public void delete(Resource resource) {
        resourceDao.delete(resource);
    }

    @Transactional
    @Override
    public void deleteById(Serializable id) {
        resourceDao.deleteById(id);
    }
    //endregion
}
