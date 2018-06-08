package com.umssonline.social.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;

@Service
public interface SocialService<TEntity> {

    @Transactional(readOnly = true)
    TEntity findById(Serializable id) throws Exception;
    @Transactional(readOnly = true)
    Collection<TEntity> findByProperty(String propertyName);
    @Transactional(readOnly = true)
    Collection<TEntity> findAll();
    @Transactional
    TEntity save(TEntity entity) throws Exception;
    @Transactional
    TEntity update(TEntity entity) throws Exception;
    @Transactional
    void delete(TEntity entity);
    @Transactional
    void deleteById(Serializable id);
}
