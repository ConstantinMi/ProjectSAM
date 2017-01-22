package ro.uaic.feaa.storage.impl;

import org.springframework.stereotype.Repository;
import ro.uaic.feaa.models.Person;
import ro.uaic.feaa.storage.IPersonDAO;

import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class PersonDAOImpl extends GenericHibernateDAO<Person, Long> implements IPersonDAO {

    public PersonDAOImpl() {
        super(Person.class);
    }

    @Override
    public Optional<Person> findByUsername(String username) {
        TypedQuery<Person> query = getEntityManager().createQuery("select p from Person p where p.user.username=:username", Person.class);
        query.setParameter("username", username);

        return Optional.ofNullable(getEntity(query));
    }
}
