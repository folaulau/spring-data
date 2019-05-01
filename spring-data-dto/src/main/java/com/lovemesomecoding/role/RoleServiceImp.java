package com.lovemesomecoding.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovemesomecoding.user.User;

@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> getByUserId(Long userId) {
		// TODO Auto-generated method stub
		return roleRepository.findByUsersId(userId);
	}

}
