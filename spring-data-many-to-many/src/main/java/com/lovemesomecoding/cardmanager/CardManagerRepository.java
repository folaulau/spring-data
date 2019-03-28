package com.lovemesomecoding.cardmanager;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CardManagerRepository extends JpaRepository<CardManager, Long>{

	CardManager findByUserId(Long userId);
}
