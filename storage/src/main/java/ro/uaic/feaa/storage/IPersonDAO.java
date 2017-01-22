package ro.uaic.feaa.storage;

import ro.uaic.feaa.models.Person;

import java.util.Optional;

/**
 * Created by Claudiu on 12/26/2016.
 */
public interface IPersonDAO extends IGenericHibernateDAO<Person, Long> {

    Optional<Person> findByUsername(String username);

}
