package ro.uaic.feaa.storage;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Created by Claudiu on 12/13/2016.
 */
public interface IGenericHibernateDAO<T, PK> {

    /**
     * Generic method for creating a object
     * @param t
     * @return
     */
    T createNew(T t);

    /**
     * Generic method for updating an object
     * @param t
     * @return
     */
    T update(T t);

    /**
     * Generic method for retrieving a object by ID
     * @param id
     * @return
     */
    Optional<T> findById(PK id);

    /**
     * Generic method to delete a object by ID
     * @param id
     */
    void delete(PK id);

    /**
     * Generic method to get a list of objects with or without a limit
     * @param maxCount
     * @return
     */
    List<T> findAll(Integer maxCount);

    default T getEntity(TypedQuery<T> query) {
        T t = null;

        try {
            t = query.getSingleResult();
        } catch (NoResultException nre) {
            // Just catch
        }

        return t;
    }

}
