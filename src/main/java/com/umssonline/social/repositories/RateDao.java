package com.umssonline.social.repositories;

import com.umssonline.social.models.Score;

import java.io.Serializable;
import java.util.Collection;

public interface RateDao {

    Score findById(Serializable id);
    Collection<Score> findAll();
    Score create(Score score);
    Score update(Score score);
    void delete(Score score);
    void deleteById(Serializable id);
}
