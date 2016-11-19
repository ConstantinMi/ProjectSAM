package ro.uaic.feaa.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ro.uaic.feaa.models.Users;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(path = "/welcome")
public class Controller {

    @RequestMapping(method = RequestMethod.GET)
    public String hello(){
        return String.format("Hello! Today's date is %s.\nEnjoy your day :)",
                new SimpleDateFormat("dd MMMM, yyyy hh:mm:ss aa")
                        .format(new Date()));
    }

    @RequestMapping(path = "/me",method = RequestMethod.GET)
    @ResponseBody
    public Users getUser() {
        Users user = new Users();
        user.setUsername("claudiu");
        user.setPassword("parola");
        return user;
    }

}
