package com.umssonline.social.repositories.impl;

import com.umssonline.social.models.entity.Share;
import com.umssonline.social.repositories.api.ExtendedShareDao;
import org.springframework.stereotype.Repository;

@Repository
public class ShareDaoImpl extends AbstractJpaDao<Share> implements ExtendedShareDao {

    //region Constructors
    public ShareDaoImpl() {
        super();
        setClazz(Share.class);
    }
    //endregion
}
