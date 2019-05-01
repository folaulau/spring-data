package com.lovemesomecoding.user;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovemesomecoding.dto.UserDto;
import com.lovemesomecoding.dto.UserMapper;
import com.lovemesomecoding.utils.ObjectUtils;

@Service
public class UserServiceImp implements UserService{

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;

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

	@Override
	public List<User> getAllUserByRole(String authority) {
		// TODO Auto-generated method stub
		return userRepository.findByRolesAuthority(authority);
	}

	@Override
	public User getProfileById(Long id) {
	
		/*
		
		// Manual way
		String searchQuery = "select new com.lovemesomecoding.dto.UserDto(user.uid,user.name,user.email,user.age) from User user where user.id = :id";
		
		TypedQuery<UserDto> typedQuery = this.entityManager.createQuery(searchQuery, UserDto.class);
		typedQuery.setParameter("id", id);
		
		UserDto userDto = typedQuery.getSingleResult();
		
		log.info("userDto: {}",ObjectUtils.toJson(userDto));
		 */
		
		UserDto userDto = userRepository.getUserProfileWithRoles(id);
		
		log.info("userDto: {}",ObjectUtils.toJson(userDto));
		
		return userMapper.userDtoToUser(userDto);
	}
	
}
