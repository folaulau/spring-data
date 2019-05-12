package com.lovemesomecoding.user;

import java.util.Optional;

public interface UserService {
	
	User create(User user);
	
	User getById(Long id);
	
	User getProfileById(Long id);
	
	User getByUid(String uid);
	
	Optional<User> findByUid(String uid);

	Optional<User> findByEmail(String email);
	
	User getByEmail(String email);

	User update(User user);

	void remove(Long id);
}
