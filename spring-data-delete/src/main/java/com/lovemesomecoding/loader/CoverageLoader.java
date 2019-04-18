package com.lovemesomecoding.loader;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovemesomecoding.address.Address;
import com.lovemesomecoding.coverage.Coverage;
import com.lovemesomecoding.coverage.CoverageRepository;
import com.lovemesomecoding.member.Member;
import com.lovemesomecoding.utils.ObjectUtils;
import com.lovemesomecoding.utils.RandomGeneratorUtils;

@Component
public class CoverageLoader {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CoverageRepository coverageRepository;
	
	@PostConstruct
	public void init() {
		
		Coverage coverage = new Coverage();
		
		coverage = coverageRepository.saveAndFlush(coverage);
		log.info("1. coverage: {}", ObjectUtils.toJson(coverage));
		
		for(int i=0;i<5;i++) {
			Member member = new Member();
			member.setFirstName(RandomGeneratorUtils.getUuid());
			member.setLastName(RandomGeneratorUtils.getUuid());
			member.setCoverage(coverage);
			coverage.addMember(member);
			
			Address address = new Address();
			
			address.setCity("Inglewood");
			address.setState("CA");
			address.setStreet("4849 w 111th st");
			address.setZip("90304");
			
			member.setAddress(address);
		}
		log.info("2. coverage: {}", ObjectUtils.toJson(coverage));
		
		coverage = coverageRepository.saveAndFlush(coverage);
		log.info("3. coverage: {}", ObjectUtils.toJson(coverage));
		
		coverageRepository.delete(coverage);
		
		
		
	}
}
