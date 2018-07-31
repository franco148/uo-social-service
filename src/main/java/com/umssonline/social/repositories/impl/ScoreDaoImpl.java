package com.umssonline.social.repositories.impl;

import com.umssonline.social.models.entity.Score;
import com.umssonline.social.repositories.api.ExtendedScoreDao;
import org.springframework.stereotype.Repository;

@Repository
public class ScoreDaoImpl extends AbstractJpaDao<Score> implements ExtendedScoreDao {

    //region Constructors
    public ScoreDaoImpl() {
        super();
        setClazz(Score.class);
    }
    //endregion
}
