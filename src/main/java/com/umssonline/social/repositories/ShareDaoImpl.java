package com.umssonline.social.repositories;

import com.umssonline.social.models.Share;

public class ShareDaoImpl extends AbstractJpaDao<Share> implements ShareDao {

    //region Constructors
    public ShareDaoImpl() {
        super();
        setClazz(Share.class);
    }
    //endregion
}
