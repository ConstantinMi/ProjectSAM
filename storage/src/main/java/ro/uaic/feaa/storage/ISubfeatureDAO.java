package ro.uaic.feaa.storage;

import ro.uaic.feaa.models.SubFeature;

import java.util.List;

/**
 * Created by Claudiu on 1/22/2017.
 */
public interface ISubfeatureDAO extends IGenericHibernateDAO<SubFeature, Long> {

    List<SubFeature> getSubFeatures(Long featureId);

}
