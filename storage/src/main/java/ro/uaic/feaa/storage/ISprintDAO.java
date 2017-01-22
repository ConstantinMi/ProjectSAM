package ro.uaic.feaa.storage;

import org.joda.time.DateTime;
import ro.uaic.feaa.models.Sprint;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Optional;

/**
 * Created by Claudiu on 1/10/2017.
 */
public interface ISprintDAO extends IGenericHibernateDAO<Sprint, Long> {

    Optional<Sprint> findActiveSprint(DateTime dateTime);

    Optional<Sprint> findMostRecentSprint();

}
