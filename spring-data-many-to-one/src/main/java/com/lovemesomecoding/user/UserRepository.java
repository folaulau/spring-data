package com.lovemesomecoding.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUid(String uuid);
	
	User getById(Long id);
	
	User getByUid(String uid);
}
