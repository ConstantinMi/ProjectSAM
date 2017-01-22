package ro.uaic.feaa.services.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.uaic.feaa.dto.UsersDTO;
import ro.uaic.feaa.models.Users;
import ro.uaic.feaa.storage.IUsersDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Claudiu on 1/12/2017.
 */
@Component
public class ProjectUserUtils {

    @Autowired
    private IUsersDAO usersDAO;

    @Autowired
    private UsersUtils usersUtils;

    public List<UsersDTO> getUsersDTOByIds(List<Long> userIds) {
        List<Users> users = new ArrayList<>();

        userIds.forEach(id -> {
            usersDAO.findById(id).ifPresent(users::add);
        });

        return users.stream().map(usersUtils::fromModelToDTO).collect(Collectors.toList());
    }
}
