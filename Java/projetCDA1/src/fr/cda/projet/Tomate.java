package fr.cda.projet;

import java.util.*;


public class Tomate<L,J> implements Legume<L,J>{

	private	L variete;
    private J jardin;
    String couleur;

    public Tomate(L v, String c, J j){

        this.variete=v;
        this.couleur=c;
        this.jardin=j;

    }//fin constructeur

    
	public J getJardin() {
		return jardin;
	}


	public void setJardin(J jardin) {
		this.jardin = jardin;
	}


	public void setVariete(L variete) {
		this.variete = variete;
	}


	public L getLegume() {
		return variete;
	}

	

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

}//fin class Tomate