// Projet 1 CDA
//
// MASSAMPU EVORA TAVARES Rafael
//16.10.22
//
package fr.cda.projet;

import java.util.*;

// Classe de definition d'une commande
//
public class Commande
{
    // Les caracteristiques d'une commande
    //
    private int     numero;         // numero de la commande
    private String  date;           // date de la commande. Au format JJ/MM/AAAA
    private String  client;         // nom du client
    
    private ArrayList<String> references; // les references des produits de la commande
    private boolean livred;
    private String pq;


    //TODO vous devez coder le reste (constructeur, methodes ...)

    public Commande(int num, String dt, String cli){
    	
    	this.numero=num;
    	this.date=dt;
    	this.client=cli;
    	
    	references = new ArrayList<String>();
    	livred=false;
    	pq="\n";
    	
    	
    }//fin constructeur
    
    /*
     * 
     * GETTERS
     * 
     */
    
    public int getNum(){
    	
    	return numero;
    	
    }
    
    public String getDate() {
    	
    	return date;
    	
    }
    
    public String getClient(){
    	
    	return client;
    	
    }
    
    public String getIdRef() {
		
		//afficher références de la commande
			    String r="";
			    for (int i = 0; i < references.size() ; i++) {
			      r= r + references.get(i)+"\n";
			    }
			    
			    return r;
			    
	}
    
    public boolean isLivred() {
		return livred;
	}

	public void setLivred(boolean livred) {
		this.livred = livred;
	}

	public String getPq() {
		return pq;
	}

	public void setPq(String pq) {
		this.pq = pq;
	}

	public ArrayList<String> getIdTab(){
    	
    	return new ArrayList<String>(references);
    }
    
    
    
    public void setNum(int n) {
    	
    	this.numero=n;
    	
    }
    
    public void setDate(String d) {
    	
    	this.date=d;
    	
    }
    
    public void setClient(String c) {
    	
    	this.client=c;
    	
    }
    
    public void setRef(String r) {
    	
    	references.add(r);
    }
    
    //Methode speciale pour supprimer toute reference dans la liste
    public void unsetId() {
    	
    	references.removeAll(references);
    }
    
    

}//fin classe Commande