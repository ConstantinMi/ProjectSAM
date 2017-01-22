package ro.uaic.feaa.services;

import ro.uaic.feaa.dto.PersonDTO;

public interface IPersonService {

    PersonDTO addPerson(String username);

    PersonDTO update(String username, PersonDTO personDTO);

    PersonDTO getPersonDetails(String username);
}
