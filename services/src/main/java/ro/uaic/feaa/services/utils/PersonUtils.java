package ro.uaic.feaa.services.utils;

import org.springframework.stereotype.Component;
import ro.uaic.feaa.dto.PersonDTO;
import ro.uaic.feaa.enums.Position;
import ro.uaic.feaa.models.Person;

@Component
public class PersonUtils {

    public PersonDTO fromModelToDTO(Person person) {
        PersonDTO personDTO = new PersonDTO();

        personDTO.setPersonId(person.getId());
        personDTO.setFirstName(person.getFirstName());
        personDTO.setLastName(person.getLastName());
        personDTO.setPosition(person.getPosition() != null ? person.getPosition().getKey() : null);

        return personDTO;
    }

    public Person fromDTOToModel(PersonDTO personDTO) {
        Person person = new Person();

        person.setId(personDTO.getPersonId());
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setPosition(Position.valueOfKey(personDTO.getPosition()));

        return person;
    }

}
