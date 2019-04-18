package com.lovemesomecoding.listener;

import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovemesomecoding.address.Address;
import com.lovemesomecoding.coverage.Coverage;
import com.lovemesomecoding.member.Member;


@Component
public class HibernateListener implements PostInsertEventListener, PostUpdateEventListener, PostDeleteEventListener{

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean requiresPostCommitHanding(EntityPersister persister) {
		log.info("requiresPostCommitHanding(..)");
		log.info("ENTITY NAME: {}",persister.getEntityName());
		return false;
	}


	@Override
	public void onPostInsert(PostInsertEvent event) {
		log.info("onPostInsert(..)");
		Object entity = event.getEntity();
//		log.info("ENTITY ID: {}",event.getId());
//		log.info("ENTITY: {}",ObjectUtils.toJson(event.getEntity()));
		
		if(entity.getClass().equals(Coverage.class)) {
			log.info("coverage created");
			Coverage coverage = (Coverage)event.getEntity();
			
		}else if(entity.getClass().equals(Member.class)) {
			log.info("member created");
			Member member = (Member)event.getEntity();
			
		}else if(entity.getClass().equals(Address.class)) {
			log.info("address created");
			Address address = (Address)event.getEntity();
			
		}else {
			//log.info("class not sync: {}", entity.getClass().getName());
		}
	}


	@Override
	public void onPostUpdate(PostUpdateEvent event) {
		log.info("onPostUpdate(..)");
		Object entity = event.getEntity();
		//log.info("ENTITY ID: {}",event.getId());
		//log.info("ENTITY: {}",ObjectUtils.toJson(entity));
		
		if(entity.getClass().equals(Coverage.class)) {
			log.info("coverage updated");
			Coverage coverage = (Coverage)event.getEntity();
			
		}else if(entity.getClass().equals(Member.class)) {
			log.info("member updated");
			Member member = (Member)event.getEntity();
			
		}else if(entity.getClass().equals(Address.class)) {
			log.info("address updated");
			Address address = (Address)event.getEntity();
		}else {
			//log.info("class not sync: {}", entity.getClass().getName());
		}
	}

	
	@Override
	public void onPostDelete(PostDeleteEvent event) {
		log.info("onPostDelete(..)");
		Object entity = event.getEntity();
		//log.info("ENTITY ID: {}",event.getId());
		//log.info("ENTITY: {}",ObjectUtils.toJson(entity));
		
		if(entity.getClass().equals(Coverage.class)) {
			log.info("coverage deleted");
			Coverage coverage = (Coverage)event.getEntity();
			
		}else if(entity.getClass().equals(Member.class)) {
			log.info("member deleted");
			Member member = (Member)event.getEntity();
			
		}else if(entity.getClass().equals(Address.class)) {
			log.info("address deleted");
		}else {
			//log.info("class not sync: {}", entity.getClass().getName());
		}
	}
	
}
