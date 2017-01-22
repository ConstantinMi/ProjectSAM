package ro.uaic.feaa.storage.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ro.uaic.feaa.storage.IGenericHibernateDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * Created by Claudiu on 12/13/2016.
 */
public abstract class GenericHibernateDAO<T, PK> implements IGenericHibernateDAO<T, PK> {

    @PersistenceContext
    private EntityManager entityManager;
    private Class<T> clazz;

    public GenericHibernateDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T createNew(T t) {
        entityManager.persist(t);
        return t;
    }

    @Override
    public T update(T t) {
        entityManager.merge(t);
        return t;
    }

    @Override
    public Optional<T> findById(PK id) {
        return Optional.ofNullable(entityManager.find(clazz, id));
    }

    @Override
    public void delete(PK id) {
        entityManager.remove(entityManager.getReference(clazz, id));
    }

    @Override
    public List<T> findAll(Integer maxCount) {
        final String query = "select t from " + clazz.getSimpleName() + " t";
        Query q = entityManager.createQuery(query);
        if (maxCount != null && maxCount > 0) {
            q.setMaxResults(maxCount);
        }
        return q.getResultList();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
