package com.lovemesomecoding.user;

import java.util.List;
import java.util.Optional;

import com.lovemesomecoding.dto.UserFullDto;

public interface UserService {
	
	User create(User user);
	
	User getById(Long id);
	
	User getProfileById(Long id);
	
	User getByUid(String uid);
	
	Optional<User> findByUid(String uid);

	
	UserFullDto getUserFullDtoById(Long userId);
	
	UserFullDto getUserFullDtoByUid(String uid);
}
