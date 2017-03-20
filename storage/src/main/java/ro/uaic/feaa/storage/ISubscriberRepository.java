package ro.uaic.feaa.storage;

import ro.uaic.feaa.models._Subscriber;

import java.util.List;

/**
 * Created by Claudiu on 3/20/2017.
 */
public interface ISubscriberRepository extends IGenericHibernateDAO<_Subscriber, Long> {

    List<_Subscriber> getFilteredSubscribers(String filter);

}
