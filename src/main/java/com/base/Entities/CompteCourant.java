package com.base.Entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{
	
	private double Decouvert;

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteCourant(String codeClient, Date dateCreation, double solde, Client client, double decouvert) {
		super(codeClient, dateCreation, solde, client);
		Decouvert = decouvert;
	}

	public double getDecouvert() {
		return Decouvert;
	}

	public void setDecouvert(double decouvert) {
		Decouvert = decouvert;
	}
	
	

	
	
	

}
