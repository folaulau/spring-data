package com.lovemesomecoding.laptop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {

	@Modifying
	@Transactional
	@Query("update Laptop lap set lap.active = false where lap.id = :id")
	Integer remove(@Param("id") Long id);
}
