package com.umssonline.social.repositories.impl;

import com.umssonline.social.models.entity.Rate;
import com.umssonline.social.repositories.api.ExtendedRateDao;
import org.springframework.stereotype.Repository;

@Repository
public class RateDaoImpl extends AbstractJpaDao<Rate> implements ExtendedRateDao {

    //region Constructors
    public RateDaoImpl() {
        super();
        setClazz(Rate.class);
    }
    //endregion
}
