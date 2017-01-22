package ro.uaic.feaa.storage.impl;

import org.springframework.stereotype.Repository;
import ro.uaic.feaa.models.ProjectUser;
import ro.uaic.feaa.models.Users;
import ro.uaic.feaa.storage.IUsersDAO;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;


/**
 * Created by Claudiu on 12/13/2016.
 */
@Repository
public class UsersDAOImpl extends GenericHibernateDAO<Users, Long> implements IUsersDAO{

    UsersDAOImpl() {
        super(Users.class);
    }

    @Override
    public Optional<Users> findByUsername(String name) {
        TypedQuery<Users> q = getEntityManager().createQuery("select u from Users u where u.username=:username", Users.class);
        q.setParameter("username", name);

        return Optional.of(getEntity(q));
    }

    @Override
    public List<Long> findUsersByProjectId(Long projectId) {
        TypedQuery<Long> query = getEntityManager().createQuery("select p.embeddedKey.userId from ProjectUser p where p.embeddedKey.projectId = :projectId", Long.class);
        query.setParameter("projectId", projectId);

        return query.getResultList();
    }
}
