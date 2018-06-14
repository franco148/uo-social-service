package com.umssonline.social.services;

import com.umssonline.social.models.Score;
import com.umssonline.social.repositories.api.ExtendedScoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;

@Service("scoreService")
public class ScoreServiceImpl implements SocialService<Score> {

    //region Properties
    @Autowired
    private ExtendedScoreDao scoreDao;
    //endregion

    //region SocialService Members
    @Override
    public Score findById(Serializable id) throws Exception {
        return null;
    }

    @Override
    public Collection<Score> findByProperty(String propertyName) {
        return null;
    }

    @Override
    public Collection<Score> findAll() {
        return null;
    }

    @Override
    public Score save(Score score) throws Exception {
        return null;
    }

    @Override
    public Score update(Score score) throws Exception {
        return null;
    }

    @Override
    public void delete(Score score) {

    }

    @Override
    public void deleteById(Serializable id) {

    }
    //endregion
}
