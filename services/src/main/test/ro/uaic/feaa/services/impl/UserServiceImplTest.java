package ro.uaic.feaa.services.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ro.uaic.feaa.dto.PersonDTO;
import ro.uaic.feaa.dto.UsersDTO;
import ro.uaic.feaa.models.Person;
import ro.uaic.feaa.models.Users;
import ro.uaic.feaa.services.utils.UsersUtils;
import ro.uaic.feaa.storage.impl.UsersDAOImpl;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

/**
 * Created by Claudiu on 1/22/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    // ---> Beans
    private UsersDAOImpl usersDAO;
    private UsersUtils usersUtils;
    private UserServiceImpl userService;

    // ---> DTOs and Models
    private UsersDTO usersDTO;
    private UsersDTO userDTO1;
    private PersonDTO personDTO;
    private Users users;


    @Before
    public void setUp() {
        userService = spy(new UserServiceImpl());
        usersUtils = spy(new UsersUtils());
        userService = spy(new UserServiceImpl());
        usersDAO = spy(new UsersDAOImpl());

        personDTO = personSetUp();


        usersDTO = new UsersDTO();
        usersDTO.setUsername("clau");
        usersDTO.setPassword("clau");

        users = new Users();
        users.setUsername(usersDTO.getUsername());
        users.setPassword(usersDTO.getPassword());

        userDTO1 = new UsersDTO();
        userDTO1.setUsername(users.getUsername());
        userDTO1.setPassword(users.getPassword());
    }

    @Test
    public void addUser() {
        doReturn(userAfterCreate()).when(usersDAO).createNew(users);
        doReturn(userDTO1).when(userService).addUser(usersDTO);
        doReturn(copyProperties()).when(usersUtils).fromModelToDTO(users);

        assertNotNull(users.getId());
        assertEquals(userDTO1.getId(), users.getId());
        assertEquals(userDTO1.getUsername(), userDTO1.getUsername());
    }

    @Test
    public void findUserByUsername() {
        doReturn(userAfterGet()).when(usersDAO).findByUsername(anyString());
        doReturn(userDTO1).when(userService).findUserByUsername(anyString());
        UsersDTO user = userService.findUserByUsername("clau");

        assertNotNull(user);
        assertEquals(user.getId(), userDTO1.getId());
    }

    private Users userAfterCreate() {
        users.setId(1L);

        return users;
    }

    private Optional<Users> userAfterGet() {
        users.setId(1L);

        return Optional.of(users);
    }

    private UsersDTO copyProperties() {
        userDTO1.setId(users.getId());
        userDTO1.setUsername(users.getUsername());
        userDTO1.setPassword(users.getPassword());

        return userDTO1;
    }

    private PersonDTO personSetUp() {
        personDTO = new PersonDTO();
        personDTO.setPersonId(2L);
        personDTO.setPosition("");
        personDTO.setLastName("");
        personDTO.setFirstName("");

        return personDTO;
    }

}