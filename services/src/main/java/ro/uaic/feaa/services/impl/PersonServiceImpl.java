package ro.uaic.feaa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.uaic.feaa.dto.PersonDTO;
import ro.uaic.feaa.enums.Position;
import ro.uaic.feaa.models.Person;
import ro.uaic.feaa.models.Users;
import ro.uaic.feaa.services.IPersonService;
import ro.uaic.feaa.services.utils.PersonUtils;
import ro.uaic.feaa.storage.IPersonDAO;
import ro.uaic.feaa.storage.IUsersDAO;

import java.util.Optional;

@Service
@Transactional
public class PersonServiceImpl implements IPersonService{

    @Autowired
    private PersonUtils personUtils;

    @Autowired
    private IPersonDAO personDAO;

    @Autowired
    private IUsersDAO usersDAO;

    @Override
    public PersonDTO addPerson(String username) {
        Optional<Users> user = usersDAO.findByUsername(username);
        Person person = new Person();
        person.setLastName("");
        person.setFirstName("");
        person.setPosition(null);
        user.ifPresent(person::setUser);

        return personUtils.fromModelToDTO(personDAO.createNew(person));
    }

    @Override
    public PersonDTO update(String username, PersonDTO personDTO) {
        Optional<Person> existingPerson = personDAO.findByUsername(username);
        existingPerson.ifPresent(p -> {
            p.setLastName(personDTO.getLastName());
            p.setFirstName(personDTO.getFirstName());
            p.setPosition(Position.valueOfKey(personDTO.getPosition()));
            personDTO.setPersonId(p.getId());
            personDAO.update(existingPerson.get());
        });


        return personUtils.fromModelToDTO(personUtils.fromDTOToModel(personDTO));
    }

    @Override
    public PersonDTO getPersonDetails(String username) {
        Optional<Person> person = personDAO.findByUsername(username);

        return person.map(p -> personUtils.fromModelToDTO(p)).orElse(null);
    }

}
