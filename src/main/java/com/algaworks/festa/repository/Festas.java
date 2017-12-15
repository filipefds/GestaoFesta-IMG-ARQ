package com.algaworks.festa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.algaworks.festa.model.Festa;

public interface Festas extends JpaRepository<Festa, Long> {
	
	
}