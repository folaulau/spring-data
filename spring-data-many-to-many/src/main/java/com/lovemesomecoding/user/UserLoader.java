package com.lovemesomecoding.user;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovemesomecoding.address.Address;
import com.lovemesomecoding.laptop.Laptop;
import com.lovemesomecoding.order.Order;
import com.lovemesomecoding.role.Role;
import com.lovemesomecoding.role.RoleService;
import com.lovemesomecoding.utils.ObjectUtils;
import com.lovemesomecoding.utils.RandomGeneratorUtils;

@Component
public class UserLoader {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
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
	
	public void loadOneToManyBidirectionalRelationship() {
		log.info("loading one-to-many bidirectional relationship...");
		
		User user = new User();
		//user.setId(new Long(55));
		user.setUid(RandomGeneratorUtils.getUuid());
		user.setAge(21);
		user.setName("Folau");
		user.setEmail("folaukaveinga@gmail.com");
		
		Order order = new Order();
		order.setUid(RandomGeneratorUtils.getUuid());
		order.setCouponCode(RandomGeneratorUtils.getUuid());
		order.setTotalAmount(120.00);
		order.setUser(user);
		
		user.addOrder(order);
		
		Role userRole = new Role();
		userRole.setAuthority(Role.USER);
		
		user.addRole(userRole);
		
		Role adminRole = new Role();
		adminRole.setAuthority(Role.ADMIN);
		
		user.addRole(adminRole);
		
		log.info("pre persist: {}",ObjectUtils.toJson(user));
		
		user = userService.create(user);
		
		log.info("post persist: {}",ObjectUtils.toJson(user));
		
		user = userService.getById(user.getId());
		
		log.info("load from db: {}",ObjectUtils.toJson(user));
		
		log.info("User has been loaded!");
		
		List<User> users = userService.getAllUserByRole(Role.USER);
		
		for(User u : users) {
			log.info("u: {}",ObjectUtils.toJson(u));
			
			List<Role> roles = roleService.getByUserId(u.getId());
			
			log.info("roles: {}",ObjectUtils.toJson(roles));
		}
		
		
	}
}
