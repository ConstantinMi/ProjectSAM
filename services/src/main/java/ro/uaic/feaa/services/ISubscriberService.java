package ro.uaic.feaa.services;

import ro.uaic.feaa.models._Subscriber;

import java.util.List;

public interface ISubscriberService {

    List<_Subscriber> getFilteredSubs(String filter);

}
