package com.lovemesomecoding.role;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{

	List<Role> findByUsersId(Long userId);
}
