package com.lovemesomecoding.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUid(String uuid);

	User getById(Long id);

	User getByUid(String uid);

	@Modifying
	@Transactional
	@Query("update User u set u.name = :name where u.id = :id")
	Integer updateName(@Param("id") Long id, @Param("name") String name);
	
	@Modifying
	@Transactional
	@Query("update User u set u.active = false where u.id = :id")
	Integer remove(@Param("id") Long id);

}
