package ro.uaic.feaa.storage.impl;

import org.springframework.stereotype.Repository;
import ro.uaic.feaa.models.Feature;
import ro.uaic.feaa.models.Project;
import ro.uaic.feaa.storage.IFeatureDAO;

import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Claudiu on 1/12/2017.
 */
@Repository
public class FeatureDAOImpl extends GenericHibernateDAO<Feature, Long> implements IFeatureDAO {

    public FeatureDAOImpl() {
        super(Feature.class);
    }

    @Override
    public Optional<Feature> findByName(String featureName) {
        TypedQuery<Feature> query = getEntityManager().createQuery("select f from Feature f where f.title = :featureName", Feature.class);
        query.setParameter("featureName", featureName);

        return Optional.ofNullable(getEntity(query));
    }

    @Override
    public List<Feature> findByProject(String partialProjectName) {
        TypedQuery<Feature> query = getEntityManager().createQuery("select f from Feature f where upper(f.project.name) like upper(:partialProjectName)", Feature.class);
        query.setParameter("partialProjectName", partialProjectName);

        return query.getResultList();
    }
}
