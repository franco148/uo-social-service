package com.umssonline.social.services;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;

@Service
public interface SocialService<TEntity> {

    TEntity findById(Serializable id);
    Collection<TEntity> findByProperty(String propertyName);
    Collection<TEntity> findAll();
    TEntity save(TEntity entity) throws Exception;
    TEntity update(TEntity entity);
    void delete(TEntity entity);
    void deleteById(Serializable id);
}
