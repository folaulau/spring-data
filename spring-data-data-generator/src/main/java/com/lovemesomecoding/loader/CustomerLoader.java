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
import com.lovemesomecoding.employee.EmployeeRepository;
import com.lovemesomecoding.order.Order;
import com.lovemesomecoding.paymentmethod.PaymentMethod;
import com.lovemesomecoding.paymentmethod.PaymentMethodService;
import com.lovemesomecoding.product.Product;
import com.lovemesomecoding.product.ProductRepository;
import com.lovemesomecoding.utils.ConstantUtils;
import com.lovemesomecoding.utils.ObjectUtils;
import com.lovemesomecoding.utils.RandomGeneratorUtils;


@Component
@org.springframework.core.annotation.Order(value=BeanOrder.CUSTOMER)
public class CustomerLoader {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private EmployeeLoader employeeLoader;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostConstruct
	public void init() {
		log.info("CustomerLoader - init()");
		
		for(int i=0;i<EntityLimit.CUSTOMER;i++) {
			Customer customer = ConstantUtils.getCustomer();
			
			Long employeeId = RandomGeneratorUtils.getLongWithin(0, EntityLimit.EMPLOYEE);
			
			Optional<Employee> optEmployee = employeeRepository.findById(employeeId);
			if(optEmployee.isPresent()) {
				customer.setEmployee(optEmployee.get());
			}else {
				log.warn("employee not found, id=",employeeId);
			}
			
			
			log.info("customer: {}", ObjectUtils.toJson(customer));
			
			customer = customerRepository.saveAndFlush(customer);
			
			log.info("saved {}, customer: {}", i, ObjectUtils.toJson(customer));
		}
	}
}
