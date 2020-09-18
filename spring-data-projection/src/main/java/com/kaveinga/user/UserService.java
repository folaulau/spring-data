package com.kaveinga.user;

import java.util.List;
import java.util.Optional;

import com.kaveinga.dto.UserDTO;
import com.kaveinga.projection.UserView;

public interface UserService {

    User create(User user);

    User getById(Long id);

    UserView getUserView(String uid);

    UserDTO getUserDTO(String uuid);

    List<User> getUserNamesAndEmails();

    UserDTO getUserDTOByAge(int age);
}
