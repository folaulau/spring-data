package com.lovemesomecoding.loader;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovemesomecoding.customer.Customer;
import com.lovemesomecoding.customer.CustomerRepository;
import com.lovemesomecoding.employee.Employee;
import com.lovemesomecoding.order.Order;
import com.lovemesomecoding.order.OrderRepository;
import com.lovemesomecoding.paymentmethod.PaymentMethod;
import com.lovemesomecoding.paymentmethod.PaymentMethodService;
import com.lovemesomecoding.product.Product;
import com.lovemesomecoding.product.ProductRepository;
import com.lovemesomecoding.utils.ConstantUtils;
import com.lovemesomecoding.utils.ObjectUtils;
import com.lovemesomecoding.utils.RandomGeneratorUtils;


@Component
@org.springframework.core.annotation.Order(value=BeanOrder.ORDER)
public class OrderLoader {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductLoader productLoader;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostConstruct
	public void init() {
		log.info("OrderLoader - init()");
		
		for(int i=0;i<EntityLimit.ORDER;i++) {
			Set<Product> products = productRepository.findByIdIn(Arrays.asList(new Long(1)));
			
			Order order = ConstantUtils.getOrder(products);
			
			Customer customer = customerRepository.findById(RandomGeneratorUtils.getLongWithin(1, EntityLimit.CUSTOMER)).get();
			
			order.setCustomer(customer);
			
			log.info("order: {}", ObjectUtils.toJson(order));
			
			order = orderRepository.saveAndFlush(order);
			
			log.info("saved i: {}, order: {}", i, ObjectUtils.toJson(order));
		}
	}
}
