package ro.uaic.feaa.storage;

import ro.uaic.feaa.models.Feature;
import ro.uaic.feaa.models.Project;

import java.util.List;
import java.util.Optional;

/**
 * Created by Claudiu on 1/12/2017.
 */
public interface IFeatureDAO extends IGenericHibernateDAO<Feature, Long>{

    Optional<Feature> findByName(String featureName);

    List<Feature> findByProject(String projectName);

}
