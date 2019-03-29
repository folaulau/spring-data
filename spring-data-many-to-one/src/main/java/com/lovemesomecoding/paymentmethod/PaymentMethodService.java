package com.lovemesomecoding.paymentmethod;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PaymentMethodRepository paymentMethodRepository;
	
	public PaymentMethod save(PaymentMethod paymentMethod) {
		return paymentMethodRepository.saveAndFlush(paymentMethod);
	}
	
	public PaymentMethod getById(Long id) {
		return paymentMethodRepository.findById(id).get();
	}
	
	public List<PaymentMethod> getByUserId(Long userId) {
		return paymentMethodRepository.findByUserId(userId);
	}
}
