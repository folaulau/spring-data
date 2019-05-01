package com.lovemesomecoding.user;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovemesomecoding.dto.UserDto;
import com.lovemesomecoding.dto.UserFullDto;
import com.lovemesomecoding.dto.UserMapper;
import com.lovemesomecoding.utils.ObjectUtils;

@Service
public class UserServiceImp implements UserService {

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
	public User getProfileById(Long id) {

		UserDto userDto = userRepository.getUserProfileWithRoles(id);

		log.info("userDto: {}", ObjectUtils.toJson(userDto));

		return userMapper.userDtoToUser(userDto);
	}

	
	@Override
	public UserFullDto getUserFullDtoById(Long userId) {

		String searchQuery = "SELECT u.name, u.email, u.age, addr.state FROM user as u JOIN address as addr ON u.address_id = addr.id WHERE u.id = :id";

		
		@SuppressWarnings("deprecation")
		Query query = this.entityManager.createNativeQuery(searchQuery).unwrap(org.hibernate.query.Query.class)
				.setResultTransformer(new AliasToBeanResultTransformer(UserFullDto.class));

		query.setParameter("id", userId);

		UserFullDto result = (UserFullDto) query.getSingleResult();

		log.info("AliasToBeanResultTransformer result: {}", ObjectUtils.toJson(result));
		
		
		// named query
		
		TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("getAllUsers", User.class);
		
		List<User> users = typedQuery.getResultList();
		
		log.info("namedQuery users: {}", ObjectUtils.toJson(users));
		
		return result;
	}

	@Override
	public UserFullDto getUserFullDtoByUid(String uid) {

		String searchQuery = "SELECT u.name, u.email, u.age, addr.state, addr.zipcode FROM user as u JOIN address as addr ON u.address_id = addr.id WHERE u.uid = :uid";

		@SuppressWarnings("deprecation")
		Query query = this.entityManager.createNativeQuery(searchQuery).unwrap(org.hibernate.query.Query.class)
				.setResultTransformer(

						new ResultTransformer() {

							private static final long serialVersionUID = -1L;

							@Override
							public UserFullDto transformTuple(Object[] tuple, String[] aliases) {

								UserFullDto dto = new UserFullDto();
								
								dto.setName((String) tuple[0]);

								dto.setEmail((String) tuple[1]);

								dto.setAge((int) tuple[2]);
								
								dto.setZipcode((String) tuple[4]);

								return dto;
							}

							@Override
							public List transformList(List collection) {
								return collection;
							}
						});

		query.setParameter("uid", uid);

		UserFullDto result = (UserFullDto) query.getSingleResult();

		log.info("Customer ResultTransformer result: {}", ObjectUtils.toJson(result));
		return result;
	}

}
