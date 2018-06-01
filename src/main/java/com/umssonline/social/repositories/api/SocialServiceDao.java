package com.umssonline.social.repositories.api;


import java.io.Serializable;
import java.util.Collection;

public interface SocialServiceDao<TEntity> {

    TEntity findById(Serializable id);
    Collection<TEntity> findAll();
    TEntity create(TEntity entity);
    TEntity update(TEntity entity);
    void delete(TEntity entity);
    void deleteById(Serializable id);
}
