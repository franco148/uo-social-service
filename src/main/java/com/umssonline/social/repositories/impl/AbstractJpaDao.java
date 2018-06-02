package com.umssonline.social.repositories.impl;

import com.umssonline.social.repositories.api.SocialServiceDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Collection;

public abstract class AbstractJpaDao<TEntity> implements SocialServiceDao<TEntity> {

    //region Properties
    private Class<TEntity> clazz;

    @PersistenceContext
    private EntityManager entityManager;
    //endregion

    //region Getters & Setters

    protected final void setClazz(final Class<TEntity> clazz) {
        this.clazz = clazz;
    }

    //endregion

    //region Methods

    public TEntity findById(final Serializable id) {
        return entityManager.find(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public Collection<TEntity> findAll() {
        return entityManager.createQuery("FROM " + clazz.getName()).getResultList();
    }

    public TEntity create(final TEntity entity) {
        entityManager.persist(entity);

        return entity;
    }

    public TEntity update(final TEntity entity) {
        return entityManager.merge(entity);
    }

    public void delete(final TEntity entity) {
        entityManager.remove(entity);
    }

    public void deleteById(final Serializable id) {
        final TEntity entityToDelete = findById(id);
        entityManager.remove(entityToDelete);
    }

    //endregion
}
