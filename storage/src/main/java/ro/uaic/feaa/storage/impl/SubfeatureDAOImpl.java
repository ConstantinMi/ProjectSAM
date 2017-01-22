package ro.uaic.feaa.storage.impl;

import ro.uaic.feaa.models.SubFeature;
import ro.uaic.feaa.storage.ISubfeatureDAO;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Claudiu on 1/22/2017.
 */
public class SubfeatureDAOImpl extends GenericHibernateDAO<SubFeature, Long> implements ISubfeatureDAO{

    public SubfeatureDAOImpl() {
        super(SubFeature.class);
    }

    @Override
    public List<SubFeature> getSubFeatures(Long featureId) {
        TypedQuery<SubFeature> query = getEntityManager()
                .createQuery("select s from SubFeature s where s.feature.id = :featureId", SubFeature.class);

        return query.getResultList();
    }
}
