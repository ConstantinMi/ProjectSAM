package ro.uaic.feaa.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.uaic.feaa.dto.UsersDTO;
import ro.uaic.feaa.models.Users;
import ro.uaic.feaa.services.IPersonService;
import ro.uaic.feaa.services.IUserService;
import ro.uaic.feaa.services.utils.UsersUtils;
import ro.uaic.feaa.storage.IUsersDAO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Claudiu on 12/13/2016.
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private IUsersDAO usersDAO;

    @Autowired
    private UsersUtils usersUtils;

    @Autowired
    private IPersonService personService;

    @Override
    public List<UsersDTO> findAll(Integer maxCount) {
        LOGGER.info(maxCount != null
                ? "--> [UsersService] Getting all users with a limit of: {} users"
                : "--> [UsersService] Getting all users", maxCount);
        return usersDAO.findAll(null).stream().map(usersUtils::fromModelToDTO).collect(Collectors.toList());
    }

    @Override
    public UsersDTO addUser(UsersDTO usersDTO) {
        LOGGER.info("--> [UserService] Creating new user with username: {}", usersDTO.getUsername());

        Users users = usersUtils.fromDTOToModel(usersDTO);
        users = usersDAO.createNew(users);
        usersDTO.setId(users.getId());
        personService.addPerson(users.getUsername());

        return usersDTO;
    }

    @Override
    public UsersDTO updateUser(String username, UsersDTO usersDTO) {
        LOGGER.info("--> [UserService] Updating existing user with id: {}", usersDTO.getId());

        Optional<Users> existingUser = usersDAO.findByUsername(usersDTO.getUsername());

        if(existingUser.isPresent()) {
            existingUser.get().setUsername(usersDTO.getUsername());
            existingUser.get().setPassword(usersDTO.getPassword());
        } else
            addUser(usersDTO);

        return usersDTO;
    }

    @Override
    public void deleteUserById(Long id) {
        LOGGER.info("--> [UserService] Deleting user with id: {}", id);

        usersDAO.delete(id);
    }

    @Override
    public UsersDTO findUserById(Long id) {
        LOGGER.info("--> [UserService] Finding user with id: {}", id);

        Optional<Users> user = usersDAO.findById(id);
        return user.map(usersUtils::fromModelToDTO).orElse(new UsersDTO());
    }

    @Override
    public UsersDTO findUserByUsername(String username) {

        Optional<Users> existingUser = usersDAO.findByUsername(username);
        return existingUser.map(usersUtils::fromModelToDTO).orElse(new UsersDTO());
    }

    public void setUserDAO(IUsersDAO userDAO) {
        this.usersDAO = userDAO;
    }

    public void setUserUtils(UsersUtils userUtils) {
        this.usersUtils = userUtils;
    }

    public void setPersonService(IPersonService personService) {
        this.personService = personService;
    }
}
