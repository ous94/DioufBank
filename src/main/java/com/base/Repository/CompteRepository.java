package com.base.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.base.Entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {
	

}
