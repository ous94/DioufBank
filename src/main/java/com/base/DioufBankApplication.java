package com.base;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.base.Entities.Client;
import com.base.Entities.Compte;
import com.base.Entities.CompteCourant;
import com.base.Entities.CompteEpargne;
import com.base.Entities.Operation;
import com.base.Entities.Retrait;
import com.base.Entities.Versement;
import com.base.Repository.ClientRepository;
import com.base.Repository.CompteRepository;
import com.base.Repository.OperationRepository;

@SpringBootApplication
public class DioufBankApplication implements CommandLineRunner{
	//pour Client
	@Autowired
	private ClientRepository clientRepository;
	//pour Compte
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private OperationRepository operationRepository;
	
	public static void main(String[] args) {
	SpringApplication.run(DioufBankApplication.class, args);
	 
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Client c1 =clientRepository.save(new Client("ousin94","ousmane"));
		
		Client c2 =clientRepository.save(new Client("ousin84","ousmane@gmail.com"));

		Client c3 =clientRepository.save(new Client("ousin74","abdou@gmail.com"));
		
		
		//creation de compte de compte
		Compte CC1 = compteRepository.save(new CompteCourant("c1", new Date(), 1000, c1, 600));
		Compte CE1 = compteRepository.save(new CompteEpargne("c2", new Date(), 1000, c1, 600));
		
		//Operation de 
		operationRepository.save(new Versement(new Date(), 20000, CC1));
		operationRepository.save(new Versement(new Date(), 50000, CE1));
		operationRepository.save(new Versement(new Date(), 340000,CC1));
		operationRepository.save(new Retrait(new Date(), 5000, CC1));

		

		

		
		

		
	}
}
