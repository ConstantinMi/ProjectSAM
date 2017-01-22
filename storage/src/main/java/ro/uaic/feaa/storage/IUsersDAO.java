package ro.uaic.feaa.storage;

import ro.uaic.feaa.models.ProjectUser;
import ro.uaic.feaa.models.Users;

import java.util.List;
import java.util.Optional;

/**
 * Created by Claudiu on 12/13/2016.
 */
public interface IUsersDAO extends IGenericHibernateDAO<Users, Long> {

    Optional<Users> findByUsername(String name);

    List<Long> findUsersByProjectId(Long projectId);

}
