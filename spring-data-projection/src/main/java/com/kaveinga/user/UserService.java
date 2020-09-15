package com.kaveinga.user;

import java.util.List;
import java.util.Optional;

import com.kaveinga.projection.UserView;

public interface UserService {
	
	User create(User user);
	
	User getById(Long id);

    UserView getUserView(String uid);
}
