package com.lovemesomecoding.loader;

import java.time.LocalDate;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovemesomecoding.address.Address;
import com.lovemesomecoding.laptop.Laptop;
import com.lovemesomecoding.laptop.LaptopRepository;
import com.lovemesomecoding.user.User;
import com.lovemesomecoding.user.UserRepository;
import com.lovemesomecoding.user.UserService;
import com.lovemesomecoding.utils.ObjectUtils;
import com.lovemesomecoding.utils.RandomGeneratorUtils;

@Component
public class UserLoader {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LaptopRepository laptopRepository;

	@PostConstruct
	public void init() {
		log.info("loading unidirectional relationship...");

		User user = createUser();

		log.info("pre persist: {}", ObjectUtils.toJson(user));

		user = userService.create(user);

		log.info("post persist: {}", ObjectUtils.toJson(user));

		log.info("User has been loaded!");

		int updated = userRepository.updateName(user.getId(), "");

		user = userService.getById(user.getId());

		log.info("user after updated: {}", ObjectUtils.toJson(user));

		int laptopRemoved = laptopRepository.remove(user.getLaptop().getId());

		user = userService.getById(user.getId());

		log.info("user after laptop removed: {}", ObjectUtils.toJson(user));
	}

	public User createUser() {
		User user = new User();
		user.setUid(RandomGeneratorUtils.getUuid());
		user.setDob(DateUtils.addYears(new Date(), 12));
		user.setName("Folau");
		user.setEmail("folaukaveinga@gmail.com");

		Laptop macbook = new Laptop();
		macbook.setType("Apple");
		macbook.setModelNumber("asdfasd");
		macbook.setSerialNumber("asdfwerqwer");
		macbook.setUser(user);
		macbook.setYear(LocalDate.now());

		user.setLaptop(macbook);

		return user;

	}
}
