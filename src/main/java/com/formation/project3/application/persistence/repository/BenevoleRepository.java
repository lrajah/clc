package com.formation.project3.application.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.formation.project3.application.persistence.entity.Benevole;


public interface BenevoleRepository extends JpaRepository<Benevole, Long> {
	
	@Query (value = "SELECT * FROM benevole WHERE Login=?1 AND Password=?2", nativeQuery = true)
	Optional<Benevole> findByLogin(String login, String pwd);
}
