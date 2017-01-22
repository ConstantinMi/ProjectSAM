package ro.uaic.feaa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.uaic.feaa.dto.PersonDTO;
import ro.uaic.feaa.services.IPersonService;

@RestController
@RequestMapping("/users/{username:.+}/personalDetails")
public class PersonsController {

    @Autowired
    private IPersonService personService;

    @RequestMapping(method = RequestMethod.PUT)
    public PersonDTO addPersonDetails(@PathVariable String username, @RequestBody PersonDTO personDTO) {
        return personService.update(username, personDTO);
    }

    @RequestMapping(method = RequestMethod.GET)
    public PersonDTO getPersonDetails(@PathVariable String username) {
        return personService.getPersonDetails(username);
    }

}
