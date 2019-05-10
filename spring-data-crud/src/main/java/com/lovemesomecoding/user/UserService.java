package com.lovemesomecoding.user;

import java.util.Optional;

public interface UserService {
	
	User create(User user);
	
	User getById(Long id);
	
	User getByUid(String uid);
	
	Optional<User> findByUid(String uid);
	
	User updateName(Long id, String name);
}
