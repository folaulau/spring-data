package com.lovemesomecoding.user;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovemesomecoding.address.Address;
import com.lovemesomecoding.laptop.Laptop;
import com.lovemesomecoding.utils.ObjectUtils;
import com.lovemesomecoding.utils.RandomGeneratorUtils;

@Component
public class UserLoader {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;
	
//	@PostConstruct
	public void loadUnidirectionalRelationship() {
		log.info("loading unidirectional relationship...");
		
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
		
		log.info("User has been loaded!");
	}
	
	public void loadBidirectionalRelationship() {
		log.info("loading bidirectional relationship...");
		
		User user = new User();
		user.setUid(RandomGeneratorUtils.getUuid());
		user.setAge(21);
		user.setName("Folau");
		user.setEmail("folaukaveinga@gmail.com");
		
		Laptop macbook = new Laptop();
		macbook.setType("Apple");
		macbook.setModelNumber("asdfasd");
		macbook.setSerialNumber("asdfwerqwer");
		macbook.setUser(user);
		macbook.setYear(LocalDate.now());
		
		user.setLaptop(macbook);
		
		log.info("pre persist: {}",ObjectUtils.toJson(user));
		
		user = userService.create(user);
		
		log.info("post persist: {}",ObjectUtils.toJson(user));
		
		user = userService.getByUid(user.getUid());
		
		log.info("load from db: {}",ObjectUtils.toJson(user));
		
		log.info("User has been loaded!");
	}
}
