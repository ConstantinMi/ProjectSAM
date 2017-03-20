package ro.uaic.feaa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.uaic.feaa.models._Subscriber;
import ro.uaic.feaa.services.ISubscriberService;
import ro.uaic.feaa.storage.ISubscriberRepository;

import java.util.List;

@Service
@Transactional
public class SubscriberServiceImpl implements ISubscriberService {

    @Autowired
    private ISubscriberRepository subscriberRepository;

    @Override
    public List<_Subscriber> getFilteredSubs(String filter) {
        return subscriberRepository.getFilteredSubscribers(filter);
    }
}
