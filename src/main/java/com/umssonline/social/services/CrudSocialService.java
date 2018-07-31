package com.umssonline.social.services;

import java.io.Serializable;
import java.util.Collection;

public interface CrudSocialService<TEntity> {

    TEntity findById(Serializable id);

    Collection<TEntity> findByProperty(String propertyName);

    Collection<TEntity> findAll();

    TEntity save(TEntity entity);

    TEntity update(TEntity entity);

    void delete(TEntity entity);

    void deleteById(Serializable id);
}
