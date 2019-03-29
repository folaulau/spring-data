package com.lovemesomecoding.user;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovemesomecoding.paymentmethod.PaymentMethod;
import com.lovemesomecoding.paymentmethod.PaymentMethodService;
import com.lovemesomecoding.utils.ObjectUtils;
import com.lovemesomecoding.utils.RandomGeneratorUtils;

@Component
public class UserLoader {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;
	
	@Autowired
	private PaymentMethodService paymentMethodService;
	
//	@PostConstruct
	public void loadUnidirectionalRelationship() {
		log.info("loading unidirectional relationship...");
		
		User user = new User();
		user.setUid(RandomGeneratorUtils.getUuid());
		user.setAge(21);
		user.setName("Folau");
		user.setEmail("folaukaveinga@gmail.com");
		
		log.info("pre persist: {}",ObjectUtils.toJson(user));
		
		user = userService.create(user);
		
		log.info("post persist: {}",ObjectUtils.toJson(user));
		
		PaymentMethod pm = new PaymentMethod();
		pm.setUser(user);
		pm.setBrand("VISA");
		pm.setLast4("3421");
		pm.setName("Folau Kaveinga");
		
		pm = paymentMethodService.save(pm);
		
		log.info("pm: {}",ObjectUtils.toJson(pm));
		
		pm = new PaymentMethod();
		pm.setUser(user);
		pm.setBrand("Capital One");
		pm.setLast4("3948");
		pm.setName("Folau Kaveinga");
		
		pm = paymentMethodService.save(pm);
		
		log.info("pm: {}",ObjectUtils.toJson(pm));
		
		List<PaymentMethod> pms = paymentMethodService.getByUserId(user.getId());
		
		log.info("pms: {}",ObjectUtils.toJson(pms));
	}
}
