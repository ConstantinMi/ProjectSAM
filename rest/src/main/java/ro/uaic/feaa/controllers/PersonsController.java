package ro.uaic.feaa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.uaic.feaa.dto.PersonDTO;
import ro.uaic.feaa.services.IPersonService;

import java.security.Principal;

@RestController
@RequestMapping("/users/me/personalDetails")
public class PersonsController {

    @Autowired
    private IPersonService personService;

    @RequestMapping(method = RequestMethod.PUT)
    public PersonDTO addPersonDetails(Principal principal, @RequestBody PersonDTO personDTO) {
        return personService.update(principal.getName(), personDTO);
    }

    @RequestMapping(method = RequestMethod.GET)
    public PersonDTO getPersonDetails(Principal principal) {
        return personService.getPersonDetails(principal.getName());
    }

}
