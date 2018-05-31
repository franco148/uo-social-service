package com.umssonline.social.services;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;

@Service
public interface SocialService<T> {

    T findById(Serializable id);
    Collection<T> findByProperty(String propertyName);
    Collection<T> findAll();
    T save(T entity);
    T update(T entity);
    void delete(T entity);
    void deleteById(Serializable id);
}
