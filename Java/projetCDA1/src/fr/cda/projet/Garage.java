package fr.cda.projet;

import java.util.*;


public class Garage{

    String nom;
    String adresse;
    int surface;

    public Garage(String n, String a,int s){

        this.nom=n;
        this.adresse=a;
        this.surface=s;

    }//fin constructeur

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}
    
    

}//fin class Garage