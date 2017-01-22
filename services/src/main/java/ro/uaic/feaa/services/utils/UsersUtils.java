package ro.uaic.feaa.services.utils;

import org.springframework.stereotype.Component;
import ro.uaic.feaa.dto.UsersDTO;
import ro.uaic.feaa.models.Users;

@Component
public class UsersUtils {

    public UsersDTO fromModelToDTO(Users user) {
        UsersDTO dto = new UsersDTO();
        if (user != null) {
            dto.setId(user.getId());
            dto.setUsername(user.getUsername());
            dto.setPassword(user.getPassword());

            return dto;
        }
        else
            return new UsersDTO();
    }

    public Users fromDTOToModel(UsersDTO usersDTO) {
        Users users = new Users();

        users.setUsername(usersDTO.getUsername());
        users.setPassword(usersDTO.getPassword());
        users.setEnabled(false);

        return users;
    }

}
