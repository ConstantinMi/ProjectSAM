package ro.uaic.feaa.storage;

import ro.uaic.feaa.models.Project;
import ro.uaic.feaa.models.Users;

import java.util.List;
import java.util.Optional;

/**
 * Created by Claudiu on 1/11/2017.
 */
public interface IProjectDAO extends IGenericHibernateDAO<Project, Long> {

    Optional<Project> findByName(String projectName);

}
