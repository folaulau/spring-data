package com.lovemesomecoding.role;

import java.util.List;

import com.lovemesomecoding.user.User;

public interface RoleService {

	List<Role> getByUserId(Long userId);
}
