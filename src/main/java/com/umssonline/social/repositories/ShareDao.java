package com.umssonline.social.repositories;

import com.umssonline.social.models.Share;

import java.io.Serializable;
import java.util.Collection;

public interface ShareDao {

    Share findById(Serializable id);
    Collection<Share> findAll();
    Share create(Share share);
    Share update(Share share);
    void delete(Share share);
    void deleteById(Serializable id);
}
