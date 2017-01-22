package ro.uaic.feaa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.uaic.feaa.dto.UsersDTO;
import ro.uaic.feaa.services.IUserService;
import ro.uaic.feaa.services.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public UsersDTO addUser(@RequestBody UsersDTO usersDTO) {
        return userService.addUser(usersDTO);
    }

    @RequestMapping(path = "/{username:.+}", method = RequestMethod.GET)
    public UsersDTO getUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UsersDTO> getAllUsers(@RequestParam(required = false) Integer maxCount){
        return userService.findAll(maxCount);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

}
