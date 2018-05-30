package com.umssonline.social.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Collection;

public abstract class AbstractJpaDao<T extends Serializable> {

    //region Properties
    private Class<T> clazz;

    @PersistenceContext
    private EntityManager entityManager;
    //endregion

    //region Getters & Setters

    public final void setClazz(final Class<T> clazz) {
        this.clazz = clazz;
    }

    //endregion

    //region Methods

    public T findById(final Serializable id) {
        return entityManager.find(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public Collection<T> findAll() {
        return entityManager.createQuery("FROM " + clazz.getName()).getResultList();
    }

    public T create(final T entity) {
        entityManager.persist(entity);

        return entity;
    }

    public T update(final T entity) {
        return entityManager.merge(entity);
    }

    public void delete(final T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(final Serializable id) {
        final T entityToDelete = findById(id);
        entityManager.remove(entityToDelete);
    }

    //endregion
}
