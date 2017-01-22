package ro.uaic.feaa.services;

import ro.uaic.feaa.dto.UsersDTO;

import java.util.List;

public interface IUserService {

    UsersDTO addUser(UsersDTO usersDTO);

    UsersDTO updateUser(String username, UsersDTO usersDTO);

    void deleteUserById(Long id);

    UsersDTO findUserById(Long id);

    UsersDTO findUserByUsername(String username);

    List<UsersDTO> findAll(Integer maxCount);
}
