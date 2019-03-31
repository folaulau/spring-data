package com.lovemesomecoding.user;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User create(User user) {
		return userRepository.saveAndFlush(user);
	}

	@Override
	public User getById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.getById(id);
	}

	@Override
	public Optional<User> findByUid(String uuid) {
		// TODO Auto-generated method stub
		return userRepository.findByUid(uuid);
	}

	@Override
	public User getByUid(String uid) {
		// TODO Auto-generated method stub
		return userRepository.getByUid(uid);
	}
	
}
