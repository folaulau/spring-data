package com.lovemesomecoding.loader;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovemesomecoding.address.Address;
import com.lovemesomecoding.user.User;
import com.lovemesomecoding.user.UserService;
import com.lovemesomecoding.utils.ObjectUtils;
import com.lovemesomecoding.utils.RandomGeneratorUtils;

@Component
public class UserLoader {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;
	
	@PostConstruct
	public void loadUsers() {
		log.info("loadUsers...");
		
		User user = new User();
		user.setUid(RandomGeneratorUtils.getUuid());
		user.setAge(21);
		user.setName("Folau");
		user.setEmail("folaukaveinga@gmail.com");
		
		Address address = new Address();
		address.setCity("El Segundo");
		address.setState("CA");
		address.setStreet("Rosescrans");
		address.setZip("90305");
		
		user.setAddress(address);
		
		log.info("pre persist: {}",ObjectUtils.toJson(user));
		
		user = userService.create(user);
		
		log.info("post persist: {}",ObjectUtils.toJson(user));
		
		user = userService.getById(user.getId());
		
		log.info("retrieve: {}",ObjectUtils.toJson(user));
		
		log.info("User has been loaded!");
		
		userService.getUserFullDtoById(user.getId());
		
		userService.getUserFullDtoByUid(user.getUid());
	}
}
