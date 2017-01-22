package ro.uaic.feaa.storage.impl;

import org.springframework.stereotype.Repository;
import ro.uaic.feaa.models.Project;
import ro.uaic.feaa.storage.IProjectDAO;

import javax.persistence.TypedQuery;
import java.util.Optional;

/**
 * Created by Claudiu on 1/11/2017.
 */
@Repository
public class ProjectDAOImpl extends GenericHibernateDAO<Project, Long> implements IProjectDAO{

    public ProjectDAOImpl() {
        super(Project.class);
    }

    @Override
    public Optional<Project> findByName(String projectName) {

        TypedQuery<Project> query = getEntityManager().createQuery("select p from Project p where p.name = :projectName", Project.class);
        query.setParameter("projectName", projectName);

        return Optional.ofNullable(getEntity(query));
    }
}
