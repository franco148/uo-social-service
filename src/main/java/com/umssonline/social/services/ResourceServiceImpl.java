package com.umssonline.social.services;

import com.umssonline.social.models.Resource;
import com.umssonline.social.repositories.api.ExtendedResourceDao;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;

@Service("resourceService")
public class ResourceServiceImpl implements SocialService<Resource> {

    //region Properties
    @javax.annotation.Resource
    private ExtendedResourceDao resourceDao;
    //endregion

    //region Properties
    @Override
    public Resource findById(Serializable id) {
        Resource resourceFromDb = resourceDao.findById(id);

        if (resourceFromDb == null) {
            return null;
        }
        return resourceFromDb;
    }

    @Override
    public Collection<Resource> findByProperty(String propertyName) {
        return null;
    }

    @Override
    public Collection<Resource> findAll() {
        return null;
    }

    @Override
    public Resource save(Resource resource) {
        return null;
    }

    @Override
    public Resource update(Resource resource) {
        return null;
    }

    @Override
    public void delete(Resource resource) {

    }

    @Override
    public void deleteById(Serializable id) {

    }
    //endregion
}
