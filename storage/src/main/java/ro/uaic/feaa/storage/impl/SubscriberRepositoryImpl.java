package ro.uaic.feaa.storage.impl;

//import org.apache.lucene.search.Query;
//import org.hibernate.search.jpa.FullTextEntityManager;
//import org.hibernate.search.jpa.Search;
//import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.uaic.feaa.models._Subscriber;
import ro.uaic.feaa.storage.ISubscriberRepository;

import java.util.List;

@Repository
public class SubscriberRepositoryImpl extends GenericHibernateDAO<_Subscriber, Long> implements ISubscriberRepository {

    SubscriberRepositoryImpl() {
        super(_Subscriber.class);
    }

    @Override
    public List<_Subscriber> getFilteredSubscribers(String filter) {
//        FullTextEntityManager ftem = Search.getFullTextEntityManager(getEntityManager());
//        getEntityManager().getTransaction().begin();
//        QueryBuilder qb = ftem.getSearchFactory().buildQueryBuilder().forEntity(_Subscriber.class).get();
//        Query query = qb
//                .keyword()
//                .onFields("type", "identity", "profile.name")
//                .matching(filter)
//                .createQuery();
//
//        javax.persistence.Query q = ftem.createFullTextQuery(query, _Subscriber.class);
//
//        List<_Subscriber> resultList = q.getResultList();

//        getEntityManager().getTransaction().commit();
//        getEntityManager().close();

        return null;
    }
}
