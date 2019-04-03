package com.lovemesomecoding.loader;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovemesomecoding.employee.Employee;
import com.lovemesomecoding.employee.EmployeeRepository;
import com.lovemesomecoding.utils.ConstantUtils;
import com.lovemesomecoding.utils.ObjectUtils;


@Component
@org.springframework.core.annotation.Order(value=BeanOrder.EMPLOYEE)
public class EmployeeLoader {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductLoader productLoader;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostConstruct
	public void init() {
		log.info("EmployeeLoader - init()");
		
		for(int i=0;i<EntityLimit.EMPLOYEE;i++) {
			Employee employee = ConstantUtils.getEmployee();
			
			employee = employeeRepository.saveAndFlush(employee);
			log.info("saved employee:{}",ObjectUtils.toJson(employee));
		}
		
		
		
	}
}
