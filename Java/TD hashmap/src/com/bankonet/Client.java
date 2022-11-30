package com.bankonet;

import java.util.*;


public class Client {
	
	private String nom;
	private String prenom;
	private String id;
	private List<Compte> comptesList= new ArrayList<Compte>();
	Map compteMap =  new HashMap();
	
	
	public Client(String n, String p, String id) {
		
		
		this.nom=n;
		this.prenom=p;
		this.id=id;
		
	}
	
	public String toString() {
		
		String str = "Nom  :" + nom + " Prenom  :"+ prenom + " id  :" + id;
		for(Compte c : comptesList) {
			str = str + "\n Nom  :" + c.getIntitule()
			+ "Numero  :" + c.getNumero()
			+"Solde :"+ c.getSolde()
			+"\n-------------------------------";
		}
		
		return str;
	}
	
	
	public List getComptesList(){
		
		return new ArrayList<>(comptesList);
		
	}
	
	public void creerCompte(Compte c) {
		
		comptesList.add(c);
	}
	
	public void creerCompteMap(Compte c) {
		
		compteMap.put(c.getNumero(), c);
	}
	
	public void supprimerCompte(Compte c) {
		
		for(Compte co: comptesList) {
			if(c.getNumero().equals(co.getNumero())) {
				comptesList.remove(co);
			}
		}//fin for
		
	}//fin suppCompte
	
	public void supprimerCompteMap(Compte c) {
		
		
			if(compteMap.containsKey(c.getNumero())) {
				compteMap.remove(c.getNumero());
			}
		
		
	}//fin suppCompteM
	
	public Compte retournerCompte(String c) {
		
		Compte com = null;
		
		for(Compte co: comptesList) {
			if(c.equals(co.getNumero())) {
				 com=co;
			}
		}//fin for
		
	return com;
		
	}//fin retournerCompte
	
	
	public boolean retournerCompteMap(String c) {
		
		return compteMap.containsKey(c);
	}
	
	
	
	
	public void supprimerCompte(String c) throws CompteNonTrouveException {
		
	
		
		if(retournerCompte(c)==null) {
			
			 throw new CompteNonTrouveException("Compte non trouvé bg");
			
		}else {
		
		for(Compte co: comptesList) {
			if(c.equals(co.getNumero())) {
				comptesList.remove(co);
			}
		}//fin for
		}
	}//fin suppCompte
	
public void supprimerCompteMap(String c) throws CompteNonTrouveException {
		
	
		
		if(retournerCompteMap(c)==false) {
			
			 throw new CompteNonTrouveException("Compte non trouvé bg");
			
		}else {
		
		for(Compte co: comptesList) {
			if(c.equals(co.getNumero())) {
				comptesList.remove(co);
			}
		}//fin for
		}
	}//fin suppCompte
	
	
	
	
	
	
	



}//Fin client
