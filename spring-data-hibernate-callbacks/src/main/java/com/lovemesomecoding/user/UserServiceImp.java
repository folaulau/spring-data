package com.lovemesomecoding.user;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovemesomecoding.dto.SessionDTO;
import com.lovemesomecoding.dto.SignupRequest;
import com.lovemesomecoding.dto.UserMapper;
import com.lovemesomecoding.jwt.JwtPayload;
import com.lovemesomecoding.jwt.JwtTokenUtils;
import com.lovemesomecoding.role.Role;
import com.lovemesomecoding.utils.HttpUtils;
import com.lovemesomecoding.utils.ObjectUtils;
import com.lovemesomecoding.utils.PasswordUtils;
import com.lovemesomecoding.utils.RandomGeneratorUtils;

@Service
public class UserServiceImp implements UserService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private HttpServletRequest request;

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
	public User getProfileById(Long id) {

		User user = userRepository.getById(id);

		log.info("user: {}", ObjectUtils.toJson(user));

		return user;
	}

	@Override
	public Optional<User> findByEmail(String email) {
		// TODO Auto-generated method stub
		return this.userRepository.findByEmail(email);
	}

	@Override
	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		return this.userRepository.getByEmail(email);
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return userRepository.saveAndFlush(user);
	}

	@Override
	public void remove(Long id) {
		userRepository.deleteById(id);
	}
}
