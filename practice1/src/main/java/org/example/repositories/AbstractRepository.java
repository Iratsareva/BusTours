package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractRepository<T> {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create(T entity){
        entityManager.persist(entity);
    }

    @Transactional
    public T findById(Class<T> entityClass, int id){
        return entityManager.find(entityClass, id);
    }

    @Transactional
    public T update (T entity){
        return entityManager.merge(entity);
    }

    @Transactional
    public void delete (T entity){
        entityManager.remove(entity);
    }


}
