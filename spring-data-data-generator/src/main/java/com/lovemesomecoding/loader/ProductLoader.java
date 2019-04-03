package com.lovemesomecoding.loader;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovemesomecoding.product.Product;
import com.lovemesomecoding.product.ProductRepository;
import com.lovemesomecoding.utils.ConstantUtils;
import com.lovemesomecoding.utils.ObjectUtils;


@Component
@org.springframework.core.annotation.Order(value=BeanOrder.PRODUCT)
public class ProductLoader {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostConstruct
	public void init() {
		log.info("ProductLoader - init()");
		
		for(int i=0;i<EntityLimit.PRODUCT;i++) {
			Product product = ConstantUtils.getProduct(i);
			product = productRepository.saveAndFlush(product);
			log.info("product: {}", ObjectUtils.toJson(product));
		}
	}
}
