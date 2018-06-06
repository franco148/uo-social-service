package com.umssonline.social.repositories.impl;

import com.umssonline.social.models.Resource;
import com.umssonline.social.repositories.api.ExtendedResourceDao;
import org.springframework.stereotype.Repository;

@Repository
public class ResourceDaoImpl extends AbstractJpaDao<Resource> implements ExtendedResourceDao {

    //region Constructors
    public ResourceDaoImpl() {
        super();
        setClazz(Resource.class);
    }
    //endregion
}
