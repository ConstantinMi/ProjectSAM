package ro.uaic.feaa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.uaic.feaa.models._Subscriber;
import ro.uaic.feaa.services.ISubscriberService;

import java.util.List;

@RestController
@RequestMapping(path = "/subscribers")
public class _SubscriberRestController {

    @Autowired
    private ISubscriberService subscriberService;

    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public List<_Subscriber> getSubs(@PathVariable String name) {
        return subscriberService.getFilteredSubs(name);
    }

}
