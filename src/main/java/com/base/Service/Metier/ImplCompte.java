package com.base.Service.Metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.Entities.Compte;
import com.base.Entities.CompteCourant;
import com.base.Entities.Operation;
import com.base.Entities.Retrait;
import com.base.Entities.Versement;
import com.base.Repository.CompteRepository;
import com.base.Repository.OperationRepository;
import com.base.Service.Interface.Interfacecompte;



@Service
@Transactional
public class ImplCompte implements Interfacecompte {
	
	@Autowired
	public CompteRepository compteRepository;
	public OperationRepository opreationRepository;
	

	@Override
	//methode pour consuleter un compte 
	public Compte consulterCompte(String codeCpte) {
		// TODO Auto-generated method stub
		  Compte  cp1 = compteRepository.findOne(codeCpte);
		  if(cp1 == null) throw new RuntimeException("Compte Introuvable");
		
		return cp1;
	}

	@Override
	public void verser(String codeCpte, double montant) {
		// TODO Auto-generated method stub
		Compte cp =  consulterCompte(codeCpte);
		Versement versement = new Versement(new Date(), montant, cp);
		  opreationRepository.save(versement);
		  
		  double montantTotal= cp.getSolde()+montant;
			 cp.setSolde(montantTotal);
		  compteRepository.save(cp);
		  
		  
		  
	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {
		// TODO Auto-generated method stub
		retirer(codeCpte1, montant);
		verser(codeCpte2, montant);
		
		 
		
		
	} 

	@Override
	public Page<Operation> listeOperation(String codeCpte, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void retirer(String codeCpte, double montant) {
		// TODO Auto-generated method stub
		Compte cp =consulterCompte(codeCpte);
		//pour la decouverte
		double facilitecaise = 0;
		
		if(cp instanceof CompteCourant)
		facilitecaise =((CompteCourant)cp).getDecouvert();
		if(cp.getSolde()+facilitecaise< montant)
			throw new RuntimeException("Votre Solde est Insuffisant");
		Retrait retrait = new Retrait(new Date(), montant, cp);
		opreationRepository.save(retrait);
		cp.setSolde(cp.getSolde()-montant);
		compteRepository.save(cp);
		
		
		
	}

}
