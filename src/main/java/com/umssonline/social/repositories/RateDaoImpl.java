package com.umssonline.social.repositories;

import com.umssonline.social.models.Score;
import org.springframework.stereotype.Repository;

@Repository
public class RateDaoImpl extends AbstractJpaDao<Score> implements RateDao {

    //region Constructors
    public RateDaoImpl() {
        super();
        setClazz(Score.class);
    }
    //endregion
}
