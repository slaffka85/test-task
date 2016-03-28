package org.sberteh.dao;

import org.sberteh.util.ReflectionUtil;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * Generic DAO class
 */
public class GenericDao<T> implements Serializable {

    @Inject
    protected EntityManager entityManager;

    private Class<T> returnClass;


    public T find(Object id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(returnedClass(), id);
    }


    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @SuppressWarnings("unchecked")
    public List<T> fetchAll(){

        return entityManager
                .createQuery("select en from " + returnedClass().getSimpleName() + " en")
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    private Class<T> returnedClass(){
        if (returnClass == null) {
            returnClass = (Class<T>) ReflectionUtil.getTypeArguments(GenericDao.class, this.getClass()).get(0);
        }
        return returnClass;
    }

}
