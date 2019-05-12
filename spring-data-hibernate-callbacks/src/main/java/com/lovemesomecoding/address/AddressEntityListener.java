package com.lovemesomecoding.address;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lovemesomecoding.utils.ObjectUtils;

public class AddressEntityListener {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	/*
	 * Executed before the entity manager persist operation is actually 
	 * executed or cascaded. This call is synchronous with the persist operation.
	 */
	@PrePersist
	private void preSave(Address address) {
		log.info("preSave={}",ObjectUtils.toJson(address));
	}
	
	/*
	 * Executed after the entity manager persist operation is actually 
	 * executed or cascaded. This call is invoked after the database 
	 * INSERT is executed.
	 */
	@PostPersist
	private void postSave(Address address) {
		log.info("postSave={}",ObjectUtils.toJson(address));
	}
	
	/*
	 * Executed after an entity has been loaded into the current persistence 
	 * context or an entity has been refreshed.
	 */
	@PostLoad
	private void postLoad(Address address) {
		log.info("postLoad={}",ObjectUtils.toJson(address));
	}
}
