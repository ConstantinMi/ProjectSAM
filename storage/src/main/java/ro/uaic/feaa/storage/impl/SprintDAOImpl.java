package ro.uaic.feaa.storage.impl;

import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;
import ro.uaic.feaa.models.Sprint;
import ro.uaic.feaa.storage.ISprintDAO;

import javax.persistence.TypedQuery;
import java.util.Optional;

/**
 * Created by Claudiu on 1/10/2017.
 */
@Repository
public class SprintDAOImpl extends GenericHibernateDAO<Sprint, Long> implements ISprintDAO{

    public SprintDAOImpl() {
        super(Sprint.class);
    }

    @Override
    public Optional<Sprint> findActiveSprint(DateTime dateTime) {

        TypedQuery<Sprint> query = getEntityManager().createQuery("select s from Sprint s where s.endDate is not null and s.endDate > :startDate", Sprint.class);
        query.setParameter("startDate", dateTime);

        return Optional.ofNullable(getEntity(query));
    }

    @Override
    public Optional<Sprint> findMostRecentSprint() {
        TypedQuery<Sprint> query = getEntityManager().createQuery("select s from Sprint s where s.endDate = (select MAX(endDate) from Sprint)", Sprint.class);

        return Optional.ofNullable(getEntity(query));
    }

}
