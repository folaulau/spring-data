package com.lovemesomecoding.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lovemesomecoding.dto.UserDto;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUid(String uuid);
	
	User getById(Long id);
	
	User getByUid(String uid);
	
	List<User> findByRolesAuthority(String authority);
	
	@Query("select new com.lovemesomecoding.dto.UserDto(user.uid,user.name,user.email,user.age) from User user where user.id = :id")
    UserDto getUserProfile(@Param("id") Long id);
	
	@Query("select new com.lovemesomecoding.dto.UserDto(user.uid,user.name,user.email,user.age,user.address) from User user where user.id = :id")
    UserDto getUserProfileWithRoles(@Param("id") Long id);
}
