package com.base.Service.Interface;

import org.springframework.data.domain.Page;

import com.base.Entities.Compte;
import com.base.Entities.Operation;

public interface Interfacecompte {
	public Compte consulterCompte(String codeCpte);
	public void verser(String codeCpte,double montant);
	public void virement(String codeCpte1,String codeCpte2,double montant);
	public void retirer(String codeCpte,double montant);
	public Page<Operation> listeOperation(String codeCpte,int page,int size);

}  
